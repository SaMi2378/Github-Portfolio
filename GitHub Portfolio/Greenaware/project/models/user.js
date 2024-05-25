const mongoose = require('mongoose');

//define a schema for user
const UserSchema = new mongoose.Schema({
    // email: String,
    // usertitle: String,
    // userforename: String,
    // usersurname: String,
    // userAccounts: Number,
    // userDOB: Date,
    // executiveAC: { type: Boolean, default: false },

    email: { type: String, unique: true },
    usertitle: String,
    userforename: String,
    usersurname: String,
    mobileNumber: String,
    address: String,
    country: String,
    userDOB: Date,
    userAccounts: Number,
    category: String,
    accountStatus: {type: String, default: "Active"},
    accountBalance: Number,
    cardnumber: String,
    cardType: String,
    cvv: String,
    notificationPreference: String,
});

//instantiate an instance of the user model
const User = mongoose.model('sysusers', UserSchema);
//Export function to create User model class
module.exports = mongoose.model('sysusers', UserSchema);
