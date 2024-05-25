const mongoose = require("mongoose"),
    passportLocalMongoose = require("passport-local-mongoose");
const UserSchema = new mongoose.Schema({
    username: { type: String, unique: true },
});
UserSchema.plugin(passportLocalMongoose);
module.exports = mongoose.model("Logincredentials", UserSchema);