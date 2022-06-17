const express = require('express');
const bodyParser = require('body-parser');
const route = require('./routes/route.js');
const { default: mongoose } = require('mongoose');
const app = express();


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

//middleware
app.use(bodyParser.json());
app.use(morgan('tiny'));

// <<--import helper function and using it as middleware-->> \\
const authJwt = require('./helpers/jwt');
const errorHandler = require('./helpers/error-handler');
app.use(authJwt());
app.use(errorHandler);


// <<---Mongo-DB connection establishment--->> \\
mongoose.connect("mongodb+srv://talha01rahman:Abc123@cluster0.vflfgln.mongodb.net/Mongo3-DB", {
    useNewUrlParser: true
})
.then( () => console.log("MongoDb is connected"))
.catch ( err => console.log(err) )


app.use('/', route)


app.listen(process.env.PORT || 3000, function () {
    console.log('Express app running on port ' + (process.env.PORT || 3000))
});
