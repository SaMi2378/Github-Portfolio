const mongoose = require('mongoose');
const mongoDB = 'mongodb+srv://root:root@cluster0.clm3fmo.mongodb.net/Greenaware';

mongoose.connect(mongoDB);

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
console.log ("Connected successfully to MongoDB!")
});
module.exports = mongoose;
