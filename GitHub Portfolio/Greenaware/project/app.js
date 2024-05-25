const express = require("express");
const app = express();
const port = 3000;
//mongodb ORM middleware
const mongoose = require("./config/dbconfig");
const session = require("express-session");
const bodyParser = require('body-parser');
    



app.use(express.json()); // This line is crucial to send json file request from frontend to backend.

//-----direct express to static assets-----------------------
app.use(express.static("public"));

app.use(bodyParser.json());

//-----enables transfer of post data from html forms----------
app.use(express.urlencoded({ extended: true }));


//-----set ejs to generate dynamic html pages-----------------
app.set('view engine', 'ejs');
app.set('views', [__dirname + "/views",__dirname + "/views/users",__dirname + "/views/loginpages",__dirname + "/views/observer"]);



app.use(
    session({
    secret: "randomisedtext",
    resave: false,
    saveUninitialized: false,
    })
   );
   
   //authentication middleware
   const passport = require("passport");
   app.use(passport.initialize());
   app.use(passport.session());

/* routes relating to http://localhost:3000/users/ have been
stored separately for Separation of Concerns */
require("./routes/usersroutes")(app);

/*-----use ejs to render home page-------------------------*/
app.get("/", (req, res) => {
    res.render("index")
})

app.listen(port, () => {
    console.log(`App listening at http://localhost:${port}`);
});