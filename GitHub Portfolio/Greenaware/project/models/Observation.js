const mongoose = require('mongoose');

//define a schema for user
const UserSchema = new mongoose.Schema({
   
    email:{
        type: String,
        required: true,
    },
    fullname: {
        type: String,
        required: true,
    },
    date: {
        type: Date,
        required: true,
    },
    time: {
        type: String,
        required: true,
    },
    timezone: {
        type: String,
        required: true,
    },
    coordinates: {
        type: String,
        required: true,
    },
    temperature_land: {
        type: Number,
        required: true,
    },
    temperature_sea: {
        type: Number,
        required: true,
    },
    humidity: {
        type: Number,
        required: true,
    },
    wind_speed: {
        type: Number,
        required: true,
    },
    wind_direction: {
        type: Number,
        required: true,
    },
    precipitation: {
        type: Number,
        required: true,
    },
    haze: {
        type: Number,
        required: true,
    },
    notes: {
        type: String,
    },

    
});

//instantiate an instance of the user model
const User = mongoose.model('Observations', UserSchema);
//Export function to create User model class
module.exports = mongoose.model('Observations', UserSchema);
