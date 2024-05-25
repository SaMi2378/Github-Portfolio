module.exports = function (app) {
    //connect to database using details in the dbconfig file
    const mongoose = require("../config/dbconfig");
    //create an instance of user based on model
    const User = require("../models/user");
    //
    const passport = require("passport");
    const User2 = require("../models/Logincredentials");
    passport.use(User2.createStrategy());
    passport.serializeUser(User2.serializeUser());
    passport.deserializeUser(User2.deserializeUser());
    const bcrypt = require("bcrypt");
    // use observation schema 
    const Observation = require("../models/Observation");
    const Message = require('../models/Message');
    
    


    checkAuth = (req, res, next) => {
        // passport adds this to the request object
      

        if (req.isAuthenticated()) {
            return next();
        }

        res.redirect("/login");


    };

    // --------------------registration------------------------------------

    app.get("/register", (req, res) => {
        console.log(`Authenticated at /register: ${req.isAuthenticated()}`);
        res.render("register");
    });


    // app.post("/register", async (req, res) => {
    //     // Creates and saves a new user with a salt and hashed password
    //     User2.register(
    //         new User2({ username: req.body.username }),
    //         req.body.password,
    //         function (err, User2) {
    //             if (err) {
    //                 console.log(err);
    //                 return res.render("register");
    //             } else {
                    
    //                 passport.authenticate("local")(req, res, function () {
    //                     console.log(`Authenticated: ${req.isAuthenticated()}`);
    //                     res.redirect("/users/userhome");
    //                 });
    //             }
    //         }
    //     );

    app.post("/register", async (req, res) => {
        // Creates and saves a new user with a salt and hashed password
        User2.register(
            new User2({ username: req.body.username }),
            req.body.password,
            function (err, User2) {
                if (err) {
                    console.log(err);
                    return res.render("register");
                } passport.authenticate("local")(req, res, function () {
                    console.log(`Authenticated: ${req.isAuthenticated()}`);
                    // Check the user's category and redirect accordingly
                    if (req.body.category === "Support") {
                        res.redirect("/users/userhome"); // Redirect Support users to the user home page
                    } else if (req.body.category === "Observer") {
                        res.redirect("/observer/observer_menu"); // Redirect Observer users to the observer menu
                    } else {
                        res.redirect("/"); // Default redirect if the category is not set or different
                    }
                });
            }
        );


        function hashCardNumber(cardNumber) {
            // Hash the first 12 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cardNumber.substring(0, 12); // Get the first 12 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cardNumber.replace(truncatedCardNumber, '*'.repeat(12));
                        resolve(hashedNumber);
                    }
                });
            });
        }

        function hashCVV(cvv) {
            // Hash the first 3 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cvv.substring(0, 3); // Get the first 3 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cvv.replace(truncatedCardNumber, '*'.repeat(3));
                        resolve(hashedNumber);
                    }
                });
            });
        }
        
        // Usage example
        
            
        if (req.body.category =="Support")
            {
            const newUser = new User({

                //Get data sent through request.body
                email: req.body.username,
                usertitle: req.body.usertitle,
                userforename: req.body.userforename,
                usersurname: req.body.usersurname,
                mobileNumber: req.body.mobileNumber,
                address: req.body.address,
                country: req.body.country,
                userDOB: req.body.userDOB,
                userAccounts: req.body.userAccounts,
                category: req.body.category,

            });
            try {
                //Save object to database using Mongoose save() method
                const qryRes = await newUser.save();

            }
            catch (error) {
                res.status(400).json({ message: error.message });
            }

    

        }
        else {
                
            const newUser = new User({
            
                //Get data sent through request.body
                email: req.body.username,
                usertitle: req.body.usertitle,
                userforename: req.body.userforename,
                usersurname: req.body.usersurname,
                mobileNumber: req.body.mobileNumber,
                address: req.body.address,
                country: req.body.country,
                userDOB: req.body.userDOB,
                userAccounts: req.body.userAccounts,
                category: req.body.category,
                accountStatus: req.body.accountStatus,
                accountBalance: req.body.accountBalance,
                cardnumber: await hashCardNumber(req.body.cardnumber),
                cardType: req.body.cardType,
                cvv: await hashCVV( req.body.cvv),
                notificationPreference: req.body.notificationPreference


            });

            try {
                //Save object to database using Mongoose save() method
                const qryRes = await newUser.save();

            }
            catch (error) {
                res.status(400).json({ message: error.message });
            }

        }
       

    });
    //              registration coding end                         //
    // ------------------------------------------------------------ //




    // ------------------- Login coding start --------------------- //
    // ------------------------------------------------------------ //

    app.get("/login", (req, res) => {
        console.log(`Authenticated at /login: ${req.isAuthenticated()}`);
        res.render("login");


        
    });


    // app.post(
    //     "/login",
    //     passport.authenticate("local", {
    //         successRedirect: "/users/userhome",
    //         failureRedirect: "/login",
    //     })
    // );

    app.post(
        "/login",
        async (req, res, next) => {
            try {
                // Find the user in the User collection
                const user = await User.findOne({ email: req.body.username });
                if (!user) {
                    // User not found in the User collection
                    return res.redirect("/login"); // Redirect to login page
                }
    
                // Check if the user's category is Support and account status is active
                if (user.category === "Support" && user.accountStatus === "Active") {
                    // Proceed to authenticate using Passport for Support
                    req.userCategory = "Support"; // Store user category in request object
                    next();
                } else if (user.category === "Observer" && user.accountStatus === "Active") {
                    // Proceed to authenticate using Passport for Observer
                    req.userCategory = "Observer"; // Store user category in request object
                    next();
                } else {
                    // User does not meet the criteria, redirect to login page
                    return res.redirect("/login");
                    
                }
            } catch (error) {
                console.error("Error:", error);
                res.redirect("/login");
            }
        },(req, res, next) => {
            passport.authenticate("local", (err, user, info) => {
                if (err) {
                    return next(err);
                }
                if (!user) {
                    return res.redirect('/login');
                }
                req.logIn(user, (err) => {
                    if (err) {
                        return next(err);
                    }
                    // Redirect based on user category
                    if (req.userCategory === "Support") {
                        return res.redirect("/users/userhome"); // Redirect Support users to the common user home page
                    } else if (req.userCategory === "Observer") {
                        return res.redirect("/observer/observer_menu"); // Redirect Observer users to the Observer menu
                    }
                    return res.redirect("/users/userhome"); // Default redirect to the common user home page
                });
            })(req, res, next);
});




    

    app.get("/users/userhome", checkAuth, (req, res) => {
        console.log(`Authenticated at /users/userhome: ${req.isAuthenticated()}`);
        res.render("userhome");
    });



    // ---------------------------------------




    // change password section
    

    
    app.get("/changepassword", checkAuth,(req,res) => {
        console.log(`Authenticated at /changepassword: ${req.isAuthenticated()}`);
        res.render("changepassword");
    })

    app.post("/changepassword", async (req, res) => {
        const { username, newPassword, confirmPassword } = req.body;
        
        // Check if new password and confirm password match
        if (newPassword !== confirmPassword) {
            return res.status(400).json({ message: "New password and confirm password do not match" });
        }
        
        try {
            // Find the user in the User2 schema
            // const user = await User2.findByUsername(username);
            const user = await User2.findByUsername(username)
            if (!user) {
                return res.send(`<script>alert("User not found"); window.history.back();</script>`);
                
            }
            
            // // Compare old password with the hashed password stored in the database
            // const isAuthentic = await bcrypt.compare(prevPassword, user.hash);
            
            if (req.user.username !== username)
            {
                return res.send(`<script>alert("Username incorrect! Please use your email address."); window.history.back();</script>`);
            }
                    
            
            // Change password to the new one
            await user.setPassword(newPassword);
            await user.save();

            console.log("Password changed successfully");
            res.send(`<script>alert("Password changed successfully"); window.location.href = "/";</script>`);

            // res.redirect("/users/userhome");

        } catch (error) {
            console.error("Error changing password:", error);
            res.status(500).json({ message: "Failed to change password. Please try again later." });
        }
    });

    // -------------------------- change pass 2 for obsever menu ------------------ //

    app.get("/changepasswordob", checkAuth,(req,res) => {
        console.log(`Authenticated at /changepasswordob: ${req.isAuthenticated()}`);
        res.render("changepasswordob");
    })

    app.post("/changepasswordob", async (req, res) => {
        const { username, newPassword, confirmPassword } = req.body;
        
        // Check if new password and confirm password match
        if (newPassword !== confirmPassword) {
            return res.status(400).json({ message: "New password and confirm password do not match" });
        }
        
        try {
            // Find the user in the User2 schema
            // const user = await User2.findByUsername(username);
            const user = await User2.findByUsername(username)
            if (!user) {
                return res.send(`<script>alert("User not found"); window.history.back();</script>`);
                
            }
            
            // // Compare old password with the hashed password stored in the database
            // const isAuthentic = await bcrypt.compare(prevPassword, user.hash);
            
            if (req.user.username !== username)
            {
                return res.send(`<script>alert("Username incorrect! Please use your email address."); window.history.back();</script>`);
            }
                    
            
            // Change password to the new one
            await user.setPassword(newPassword);
            await user.save();

            console.log("Password changed successfully");
            res.send(`<script>alert("Password changed successfully"); window.location.href = "/";</script>`);

            

        } catch (error) {
            console.error("Error changing password:", error);
            res.status(500).json({ message: "Failed to change password. Please try again later." });
        }
    });



    // ---------------------------------------------------------------------------- //

        /* This function for long out requires a call back option 
        which this codding is giving error of callback funtion.*/
    
        // app.get("/logout", (req, res) => {
        //     console.log(`Authenticated at /logout: ${req.isAuthenticated()}`);
        //     req.logout();
        //     console.log("User has been logged out");
        //     console.log(`Authenticated at /logout: ${req.isAuthenticated()}`);
        //     res.redirect("/login");
        // });
        
    app.get("/logout", (req, res) => {
        console.log(`Authenticated at /logout: ${req.isAuthenticated()}`);
        req.logout((err) => {
            if (err) {
                console.log(err);
                return res.redirect("/login");
            }
            console.log("User has been logged out");
            console.log(`Authenticated at /logout: ${req.isAuthenticated()}`);
            res.redirect("/");
        });
    });


    // ----------------------------------------------------------

    // ----------------- Observers Menu -------------------------

    app.get("/observer/observer_menu", checkAuth, async (req, res) => {
        console.log(`Authenticated at /observer/observer_menu: ${req.isAuthenticated()}`);
        
        try {
            const loggedInObserver = req.user.username;
            // Query Support users
            const observations = await Observation.find({ email: loggedInObserver });

            // Query messages received by the logged-in user
            const receivedMessages = await Message.find({ receiverEmail: loggedInObserver });
            // Render page with both Support and Observer users
            res.render("observer_menu",{ observations: observations, receivedMessages: receivedMessages});
            
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
           
    })
   
    app.post("/observer/delete-observations", checkAuth, async (req, res) => {
        try {

            const selectedObservations = req.body.observations;
    
            // Delete selected observations from the database
            const result = await Observation.deleteMany({ _id: { $in: selectedObservations } });
    
            if (result.deletedCount > 0) {
                res.status(200).json({ message: 'Selected observations deleted successfully.' });
                console.log(`The observations (${selectedObservations}) has been deleted.`)
                
            } else {
                res.status(404).json({ message: 'No observations found with the provided IDs.' });
            }
        } catch (error) {
            console.error('Error deleting observations:', error);
            res.status(500).json({ message: 'An error occurred while deleting observations. Please try again.' });
        }
    });
    
    
    

    // ----------





    app.get('/observer/register_observation', (req, res) => {
        // Check if user is authenticated and has a username
        if (req.user && req.user.username) {
            // Pass the user object to the template
            res.render('register_observation', { user: req.user });
        } else {
            // Handle the case where user is not authenticated or does not have a username
            // You can redirect the user to the login page or handle it differently based on your application's logic
            res.redirect('/login'); // Redirect to the login page
        }
    });

    app.post("/observer/register_observation", async(req,res) => {
        
        const {
            email,
            fullname,
            date,
            time,
            timezone,
            coordinates,
            temperature_land,
            temperature_sea,
            humidity,
            wind_speed,
            wind_direction,
            precipitation,
            haze,
            notes,

        } = req.body;
        
        const loggedInObserver = req.user.username;
        const newObservation = new Observation({
            email,
            fullname,
            date,
            time,
            timezone,
            coordinates,
            temperature_land,
            temperature_sea,
            humidity,
            wind_speed,
            wind_direction,
            precipitation,
            haze,
            notes,

        });

        if (loggedInObserver !== newObservation.email)
            {
                return res.send(`<script>alert("Username incorrect! Please use your email address."); window.history.back();</script>`);
            }


        try {
            //Save object to database using Mongoose save() method
            await newObservation.save();
            console.log(`Observation has been sucessfully registered!.`)
            res.redirect("/observer/observer_menu");
        }
        catch (error) {
            res.status(400).json({ message: error.message });
        }

        // Observation.register(
        //     new Observation({ 
        //         date: req.body.date,
        //         time: req.body.time,
        //         timezone: req.body.timezone,
        //         coordinates: req.body.coordinates,
        //         temperature_land: req.body.temperature_land,
        //         temperature_sea: req.body.temperature_sea,
        //         humidity: req.body.humidity,
        //         wind_speed: req.body.wind_speed,
        //         wind_direction: req.body.wind_direction,
        //         precipitation: req.body.precipitation,
        //         haze: req.body.haze,
        //         notes: req.body.notes,


        //     }),
            
        //     function (err, Observation) {
        //         if (err) {
        //             console.log(err);
        //             return res.render("observation_menu");
        //         } else {

        //             console.log(`Observation has been sucessfully registered with id ${req.body._id}.`)
        //             res.redirect("/observer/observer_menu");

        //         }
        //     }
        // );
        
        
    });

    //----------------------------------------------------------------- //
    // -------------- view amend details ------------------------------ //



    // app.get("/observer/view_details1", checkAuth, async (req, res) => {
    //     // Get the details of the currently logged-in user
    //     const loggedInUserEmail = req.user.username;
    //     try {
    //         // Query the database to fetch details of the logged-in user
    //         const loggedInUser = await User.findOne({email:loggedInUserEmail});
    //         // Render the page with details of the logged-in user
            
    //         res.render("../observer/view_details1", { users: loggedInUser });
    //     } catch (error) {
    //         res.status(500).json({ message: error.message });
    //     }
    // });

    // app.post("/observer/view_details", async (req, res) => {
    //     //query document based on specific id passed through POST method
    //     try {
    //         const qryRes = await User.findById(req.body._id);
    //         //render form with document relating to specific user
    //         res.render("../observer/view_details", { user: qryRes });
    //     }
    //     catch (error) {
    //         res.status(500).json({ message: error.message })
    //     }
    // })




    app.get("/observer/view_amendDetails", checkAuth, async (req, res) => {
        //query all users' documents
        try {
            // save the email of the current looged user in variable loogeduser
            const loogeduser = req.user.username;
            
            // saves the details of the current logged in user with the function .findOne, filtering the email previously stored..
            const user = await User.findOne({email: loogeduser});
            
           
            //render page with form to accept choice for update, with the user details obtained from the previous function
            res.render("../observer/view_amendDetails", { qryRes: user});
        }
        catch (error) {
            // in case of error it sends a status request with the error mesage.
            res.status(500).json({ message: error.message });
        }
    });

    app.post("/observer/view_amendDetails", async (req, res) => {

        function hashCardNumber(cardNumber) {
            // Hash the first 12 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cardNumber.substring(0, 12); // Get the first 12 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cardNumber.replace(truncatedCardNumber, '*'.repeat(12));
                        resolve(hashedNumber);
                    }
                });
            });
        }

        function hashCVV(cvv) {
            // Hash the first 3 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cvv.substring(0, 3); // Get the first 3 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cvv.replace(truncatedCardNumber, '*'.repeat(3));
                        resolve(hashedNumber);
                    }
                });
            });
        }

        
        try {
            const filterId = req.body._id; // Assuming '_id' is the unique identifier, saves the id of the user in a variable filterId
            const updatedUser = req.body;  // saves the values of the updates made in the observer details in a variable.
            
            // the system checks if there is a cardNumber updated, if so it hashes that card number
            if (updatedUser.cardnumber) {   
                updatedUser.cardnumber = await hashCardNumber(updatedUser.cardnumber); 
            }
            // Checks if there is a updated cvv and in case there were any update, the system will hash the cvv.
            if (updatedUser.cvv) {
                updatedUser.cvv = await hashCVV(updatedUser.cvv);
            }

            // Check if the email has been updated
            // First the system gets the original data of the user from details previously saved in the databse.
            const originalUser = await User.findById(filterId);
            if (!originalUser) {
                // In case there are not in the database the system will prompt and error.
                return res.status(404).json({ message: "User not found" });
            }
            
            /* The system gets the originalEmail and it saves in the variable originalEmail, from the originalUser
            details collected in the previous step.*/
            const originalEmail = originalUser.email;
            /* the new updated Email is stored in the variable updatedEmail. */
            const updatedEmail = updatedUser.email;
            
            /* condition to check if the original email and the update email are identical or not. */
            if (originalEmail !== updatedEmail) {
                // Email has been changed, update User2 collection
                const user2Update = { username: updatedEmail }; // Assuming 'username' is the field for email in User2
                const filterUser2 = { username: originalEmail }; // Filter by original email
                // the system updates the details of the new email filtering the user with its original email
                // the function findOneandUPdate, saves the new email in the logindetails collection
                await User2.findOneAndUpdate(filterUser2, user2Update, { new: true });
            }
            
            // Update user details in User collection
            
            const updatedUserDoc = await User.findByIdAndUpdate(filterId, updatedUser, { new: true });
            // After succesfull changes, the system redirects to view the updates details.
            res.redirect("/observer/view_amendDetails");
        } catch (error) {
            // In case there is error the system will catch that error and send a message with the problem.
            res.status(400).json({ message: error.message });
        }
    });





    // -------------------------------------------------------- //
    // ----------------- message to support

    // app.get('/observer/message_support', checkAuth, (req, res) => {
    //     res.render("../observer/message_support")
    // });

    // app.post('/observer/message_support', async (req, res) => {
    //     try {
    //         const { senderEmail, receiverEmail, name, content, timestamp } = req.body; // Extract timestamp
    //         const message = new Message({ senderEmail, receiverEmail, name, content, timestamp }); // Include timestamp
    //         const qryRes = await message.save();
    //         res.status(201).json({ message: 'Message saved successfully' });
    //     } catch (error) {
    //         res.status(500).json({ error: 'Internal Server Error' });
    //     }
    //   });
      
    app.get('/observer/message_support', checkAuth, async (req, res) => {
        try {
            // Fetch the current user's email from the authenticated request
            const currentUserEmail = req.user.username;

            // Fetch the list of support users from the User schema where category is 'support'
            const users = await User.find({ category: 'Support' }); // Assuming 'name' and 'email' are fields in the User schema
            
            
            // renders the message support page with the currentEmail and the users details saved in users.
            res.render("../observer/message_support", { currentUserEmail, users });
        } catch (error) {
            // The system sends the console error request with the error message.
            console.error('Error fetching support users:', error);
            // sends a status with json file with the error 
            res.status(500).json({ error: 'Internal Server Error' });
        }
    });
    
    app.post('/observer/message_support', async (req, res) => {
        try {
            const { senderEmail, receiverEmail, name, content } = req.body; // No need for senderEmail, as it will be set to the current user's email
            // Assuming currentUserEmail is available after authentication

            // saves the message with the details obtained from the body (which the user has entered in the fields)
            // in the variable message.
            const message = new Message({ senderEmail, receiverEmail, name, content });
            
            // saves the message in the database.
            const qryRes = await message.save();
            // sends a console log stating the message was saved correctly
            console.log("Message saved successfully")
            // reloads the observer page uppon successfully sending message.
            res.redirect("/observer/message_support")
        } catch (error) {
            // System sending error message in case of issues.
            console.error('Error saving message:', error);
            res.status(500).json({ error: 'Internal Server Error' });
        }
    });


 // --------------------------------------------------------------

 




 //to serve static files from current location, determine parent directory
 const path = require("path");
 const parentDirectory = path.dirname(__dirname);
 //All routes related to http://localhost:3000/users/..
 
 //-------------------------------------------------------------------------
//  app.get("/users/adduser", (req, res) => {
//  res.sendFile(parentDirectory + "/public/html/users/adduser.html");
//  });
//  //-------------------------------------------------------------------------
//  app.post("/users/adduser", (req, res) => {
//  res.sendFile(parentDirectory + "/public/html/users/adduser.html");
//  //create an instance of User
//     const NewUser = new User({
//         usertitle: req.body.usertitle,
//         userforename: req.body.userforename,
//         usersurname: req.body.usersurname,
//         userAccounts: req.body.userAccounts,
//         userDOB: req.body.userDOB,
//         executiveAC: req.body.executiveAC,
//     });
//     NewUser.save()
//     //subsequent command for testing to show values that are being passed from form.
//     //string interpolation techniques for JavaScript demonstrated

//     console.log(
//         `New user: ${req.body.userforename} ${req.body.usersurname} stored in database.`
//     );
 
//     //  //redirect to "users/getuser" path to view effect of inserts in console
//     res.redirect("/users/getusers");
//  });


//-----------------------insert document-------------------------
    app.get("/users/adduser",checkAuth, (req, res) => {
        //render page with form to insert one user document
        res.render("../users/adduser");
    });
    app.post("/users/adduser", async (req, res) => {

        //     const newUser = new User({

        //         //Get data sent through request.body
        //         email: req.body.email,
        //         usertitle: req.body.usertitle,
        //         userforename: req.body.userforename,
        //         usersurname: req.body.usersurname,
        //         userAccounts: req.body.userAccounts,
        //         userDOB: req.body.userDOB,
        //         executiveAC: req.body.executiveAC
        //     });
        //     try {
        //         //Save object to database using Mongoose save() method
        //         const qryRes = await newUser.save();
        //         res.redirect("/users/getusers");
        //     }
        //     catch (error) {
        //         res.status(400).json({ message: error.message });
        //     }

        User2.register(                                     // saves in the schema User2 the username with the name and password.
        // this schema is different which saves only the login details.
            new User2({ username: req.body.username }),
            req.body.password,
            function (err, User2) {            // if there is an error, the system sends a console log with the message, and 
                if (err) {
                    console.log(err);
                    return res.render("/users/adduser");       // and it resends the user to the register new user page.
                } else {
                    // passport.authenticate("local")(req, res, function () {
                    //     console.log(`Authenticated: ${req.isAuthenticated()}`);
                        // if the details are correctly entered and stored the system will print a message of user registered in the console.
                        console.log(`The user ${req.body.userforename} has been registered as ${req.body.category}.`)
                        res.redirect("/users/userhome"); // it redirects to the support dashboard.
                    // });
                }
            }
        );


        function hashCardNumber(cardNumber) {
            // Hash the first 12 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cardNumber.substring(0, 12); // Get the first 12 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {    //hash the cardnumber with the saltrounds provided with and error checking system.
                    if (err) {
                        reject(err);            // in case there is any error the system will reject the hashing.
                    } else {
                        const hashedNumber = cardNumber.replace(truncatedCardNumber, '*'.repeat(12)); // hashes the first 12 digits of the cardnumber provided
                        resolve(hashedNumber);  // returns the hashed number back.
                    }
                });
            });
        }

        function hashCVV(cvv) {
            // Hash the first 3 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cvv.substring(0, 3); // Get the first 3 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cvv.replace(truncatedCardNumber, '*'.repeat(3)); // same sa the cardnumber, the cvv three digits are hashed.
                        resolve(hashedNumber);
                    }
                });
            });
        }

        // Usage example


        if (req.body.category == "Support") { // if the category entered in the body is Support
            const newUser = new User({
                // the following required data will be saved excluding the observer options.
                //Get data sent through request.body
                email: req.body.username,
                usertitle: req.body.usertitle,
                userforename: req.body.userforename,
                usersurname: req.body.usersurname,
                mobileNumber: req.body.mobileNumber,
                address: req.body.address,
                country: req.body.country,
                userDOB: req.body.userDOB,
                userAccounts: req.body.userAccounts,
                category: req.body.category,

            });
            try {
                //Save object to database using Mongoose save() method
                const qryRes = await newUser.save();

            }
            catch (error) {
                // if there is an error it opens a json file with the error message.
                res.status(400).json({ message: error.message });
            }



        } else {
            // in the case the category wasnt Support the system would save all the fields in the database.
            // In the schema User (which is used to store personal details)
            const newUser = new User({

                //Get data sent through request.body
                email: req.body.username,
                usertitle: req.body.usertitle,
                userforename: req.body.userforename,
                usersurname: req.body.usersurname,
                mobileNumber: req.body.mobileNumber,
                address: req.body.address,
                country: req.body.country,
                userDOB: req.body.userDOB,
                userAccounts: req.body.userAccounts,
                category: req.body.category,
                accountStatus: req.body.accountStatus,
                accountBalance: req.body.accountBalance,
                cardnumber: await hashCardNumber(req.body.cardnumber),
                cardType: req.body.cardType,
                cvv: await hashCVV(req.body.cvv),
                notificationPreference: req.body.notificationPreference


            });

            try {
                //Save object to database using Mongoose save() method
                const qryRes = await newUser.save();

            }
            catch (error) {
                res.status(400).json({ message: error.message });
            }

        }

    });



 //-------------------------------------------------------------------------
    // app.get("/users/getusers", (req, res) => {
    //     res.send("See all users in console.log!");
    //     User.find({}, function (err, findAllUsersQry) {
    //      if (err) throw err;
    //      console.log(findAllUsersQry);
    //     });
    // });

    //-------------------------view all documents-----------------------
    // app.get("/users/getusers",checkAuth, async (req, res) => {
    //     //query all users' documents
    //     try {
    //         const qryRes = await User.find();
    //         //render page with all users' documents
    //         res.render("../users/getusers", { users: qryRes });
    //     }
    //     catch (error) {
    //         res.status(500).json({ message: error.message });
    //     }
    // });

    /* This coding helps to separate the users into two table depending on their category*/
    app.get("/users/getusers", checkAuth, async (req, res) => {
        try {
            // Query Support users
            const supportUsers = await User.find({ category: "Support" });
    
            // Query Observer users
            const observerUsers = await User.find({ category: "Observer" });
    
            // Render page with both Support and Observer users
            res.render("../users/getusers", { supportUsers: supportUsers, observerUsers: observerUsers });
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    });
    

    // app.get('/users/getusers', async (req, res) => {
    //     try {
    //         res.send('See all users in console.log!');
    //         const findAllUsersQry = await User.find({}).exec();
    //         console.log(findAllUsersQry);
    //     } catch (err) {
    //         console.error(err);
    //         res.status(500).send('Internal Server Error');
    //     }
    // });
    
//-------------------------view one document-------------------------
    app.get("/users/queryuserbyid", checkAuth, async (req, res) => {
        //query all users' documents
        try {
            const qryRes = await User.find();
            //render page with form to accept choice for one user
            res.render("../users/queryuserbyid", { users: qryRes });
        }
        catch (error) {
            res.status(500).json({ message: error.message });
        }
    });
    app.post("/users/queryuser", checkAuth, async (req, res) => {
        //query document based on specific id passed through POST method
        try {
            const qryRes = await User.findById(req.body._id);
            //render form with document relating to specific user
            res.render("../users/queryuser", { user: qryRes });
        }
        catch (error) {
            res.status(500).json({ message: error.message })
        }
    })
    
    

//-------------------------delete one document------------------------
    app.get("/users/deleteuserbyid", checkAuth, async (req, res) => {
        //query all users' documents
        try {
            const qryRes = await User.find();
            //render page with form to accept choice for document deletion
            res.render("../users/deleteuserbyid", { users: qryRes });
        }
        catch (error) {
            res.status(500).json({ message: error.message })
        }
    });
    // app.post("/users/deleteuser", async (req, res) => {
    //     //delete document based on specific id passed through POST method
    //     try {
    //         const id = req.body._id;
    //         console.log(`${id} has been removed from the database`)
    //         const qryRes = await User.findByIdAndDelete(id)
    //         //show effect of deletion by redirecting to show all documents
    //         res.redirect("/users/getusers");
    //     }
    //     catch (error) {
    //         res.status(400).json({ message: error.message })
    //     }
    // });

    app.post("/users/deleteuser", async (req, res) => {
        try {
            const id = req.body._id;
    
            // Find the user in the User collection to get the email
            const user = await User.findById(id);
            if (!user) {
                return res.status(404).json({ message: "User not found" });
            }
            const userEmail = user.email;
    
            // Delete the user from User collection
            await User.findByIdAndDelete(id);
    
            // Delete the user from User2 collection based on the email
            await User2.findOneAndDelete({ username: userEmail });
    
            console.log(`${userEmail} has been removed from both collections`);
    
            // Redirect to show all documents
            res.redirect("/users/getusers");
        } catch (error) {
            res.status(400).json({ message: error.message });
        }
    });
    

    
    
    // -------------------send message system support ---------------------- //
    
    app.get('/users/message_system', checkAuth, async (req, res) => {
        try {
            // Fetch the current user's email from the authenticated request
            const currentUserEmail = req.user.username;
            
            // Fetch the list of support users from the User schema where category is 'support'
            const users = await User.find(); // Assuming 'name' and 'email' are fields in the User schema
            
            
            
            res.render("../users/message_system", { currentUserEmail, users });
        } catch (error) {
            console.error('Error fetching support users:', error);
            res.status(500).json({ error: 'Internal Server Error' });
        }
    });
    
    app.post('/users/message_system', async (req, res) => {
        try {
            const { senderEmail, receiverEmail, name, content } = req.body; // No need for senderEmail, as it will be set to the current user's email
            // Assuming currentUserEmail is available after authentication
            
            const message = new Message({ senderEmail, receiverEmail, name, content });
            const qryRes = await message.save();
            console.log("Message saved successfully")
            res.redirect("/users/message_system")
        } catch (error) {
            console.error('Error saving message:', error);
            res.status(500).json({ error: 'Internal Server Error' });
        }
    });
    
    
    
    //-------------------------update one document------------------------
    /* This codding was only to get updated the details in the users details and not in login details. */

    // app.get("/users/updateuser", checkAuth, async (req, res) => {
    //     //query all users' documents
    //     try {
    //         const qryRes = await User.find();
    //         //render page with form to accept choice for update
    //         res.render("../users/updateuser", { users: qryRes });
    //     }
    //     catch (error) {
        //         res.status(500).json({ message: error.message });
        //     }
        // });
        
        // app.post("/users/updateuser", async (req, res) => {
    //     try {
    //         const filter = req.body._id;
    //         const updateQry = req.body;
    //         const options = { new: true };
    //         const qryRes = await User.findByIdAndUpdate(
        //             filter, updateQry, options
    //         )
    
    //         //show effect of update by redirecting to show all documents
    //         res.redirect("/users/getusers");
    //     }
    //     catch (error) {
    //         res.status(400).json({ message: error.message })
    //     }
    // });
    
    // Route to fetch user details by ID
    

    app.get("/users/updateuser", checkAuth, async (req, res) => {
        //query all users' documents
        try {
            const qryRes = await User.find();
           
            //render page with form to accept choice for update
            res.render("../users/updateuser", { users: qryRes});
        }
        catch (error) {
            res.status(500).json({ message: error.message });
        }
    });

    app.post("/users/updateuser", async (req, res) => {

        function hashCardNumber(cardNumber) {
            // Hash the first 12 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cardNumber.substring(0, 12); // Get the first 12 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cardNumber.replace(truncatedCardNumber, '*'.repeat(12));
                        resolve(hashedNumber);
                    }
                });
            });
        }

        function hashCVV(cvv) {
            // Hash the first 3 characters of the card number using bcrypt
            const saltRounds = 10;
            const truncatedCardNumber = cvv.substring(0, 3); // Get the first 3 characters
            return new Promise((resolve, reject) => {
                bcrypt.hash(truncatedCardNumber, saltRounds, function (err, hash) {
                    if (err) {
                        reject(err);
                    } else {
                        const hashedNumber = cvv.replace(truncatedCardNumber, '*'.repeat(3));
                        resolve(hashedNumber);
                    }
                });
            });
        }

        try {
            const filterId = req.body._id; // Assuming '_id' is the unique identifier
            const updatedUser = req.body;
            
            if (updatedUser.cardnumber) {
                updatedUser.cardnumber = await hashCardNumber(updatedUser.cardnumber);
            }
            if (updatedUser.cvv) {
                updatedUser.cvv = await hashCVV(updatedUser.cvv);
            }

            // Check if the email has been updated
            const originalUser = await User.findById(filterId);
            if (!originalUser) {
                return res.status(404).json({ message: "User not found" });
            }
            
            const originalEmail = originalUser.email;
            const updatedEmail = updatedUser.email;
            
            if (originalEmail !== updatedEmail) {
                // Email has been changed, update User2 collection
                const user2Update = { username: updatedEmail }; // Assuming 'username' is the field for email in User2
                const filterUser2 = { username: originalEmail }; // Filter by original email
                
                await User2.findOneAndUpdate(filterUser2, user2Update, { new: true });
            }
            
            // Update user details in User collection

            
            const updatedUserDoc = await User.findByIdAndUpdate(filterId, updatedUser, { new: true });
            res.redirect("/users/updateuser");
        } catch (error) {
            res.status(400).json({ message: error.message });
        }
    });
    
    app.get('/users', async (req, res) => {
        try {
            const users = await User.find();
            res.json(users);
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    });
    
    app.get('/users/:id', async (req, res) => {
        try {
            const userId = req.params.id;
            const user = await User.findById(userId);
            if (!user) {
                return res.status(404).json({ message: 'User not found' });
            }
            res.json(user);
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    });

    



    //-------------------------------------------------------------------------
    
};
