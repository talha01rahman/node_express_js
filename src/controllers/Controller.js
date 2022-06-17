const jwt = require("jsonwebtoken");
const userModel = require("../models/Model");
const express = require('express');
const router = express.Router();
const bcrypt = require('bcryptjs');

// <---------Post Create User-------------->
// <---------Post Create User #bcrypt.hashSync-------------->
// <---------Post Create Category Data------->
// <---------Post Login User #findOne #jwt.sign-------------->
// <---------Post a new Product through category Id #findById -------------->
// <---------Post Register a New User -------------->
// <--------------Post Login a User & Creating a Token #findOne #bcrypt.compareSync #jwt.sign----------->

// <---------Get Category List #find-------------->
// <---------Get User Data #token #jwt.verify #findById-------------->
// <---------Get Category by #findById------------>
// <---------Get Product by #findById #populate------------>
// <---------Get Product count for statistical purpose #countDocuments------------>
// <---------Get `@Featured` Products in desired counts  #find #limit ------------>
// <---------Get Filtering and Getting Products Category #split #find #populate------------>
// <---------Get User details excluting password #find #select---------->

// <---------Put Udate user #findById #findOneAndUpdate-----------> 
// <---------Put Udate the category #findByIdAndUpdate------->
// <---------Put Udate the Product link categoryid #findByIdAndUpdate #isValidObjectId #findById------->
// <---------Put Hashing the User Password----------->

// <---------Delete a category----------->
// <---------Delete a Product and validate Id #findByIdAndRemove----------->


// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>
// <<<<<<<<<<< POST >>>>>>>>>>>>>>>>
// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>


// <---------Post Create User -------------->
async function createUser(req, res) {
  //You can name the req, res objects anything.
  //but the first parameter is always the request 
  //the second parameter is always the response
  let data = abcd.body;
  let savedData = await userModel.create(data);
  console.log(req.newAtribute);
  res.send({ msg: savedData });
}


// <---------Post Create User #hashSync-------------->
router.post('/', async (req,res)=>{
  let user = new User({
      name: req.body.name,
      email: req.body.email,
      passwordHash: bcrypt.hashSync(req.body.password, 10),
      phone: req.body.phone,
      isAdmin: req.body.isAdmin,
      street: req.body.street,
      apartment: req.body.apartment,
      zip: req.body.zip,
      city: req.body.city,
      country: req.body.country,
  })
  user = await user.save();

  if(!user)
  return res.status(400).send('the user cannot be created!')

  res.send(user);
})

// <---------Post Category Data-------------->
router.post('/', async (req,res)=>{
  // let data = req.body;
  let category = new Category({
      name: req.body.name,
      icon: req.body.icon,
      color: req.body.color
  })
  category = await category.save();
  // let category = await Category.create(data);
  if(!category)
  return res.status(400).send('the category cannot be created!')
  //res.status(200).send(msg: category);
  
  res.send(category);
})



// <---------Post Login User #findOne #jwt.sign-------------->
const loginUser = async function (req, res) {
  let userName = req.body.emailId;
  let password = req.body.password;

  let user = await userModel.findOne({ emailId: userName, password: password });
  if (!user)
    return res.send({
      status: false,
      msg: "username or the password is not corerct",
    });

  // Once the login is successful, create the jwt token with sign function
  // Sign function has 2 inputs:
  // Input 1 is the payload or the object containing data to be set in token
  // The decision about what data to put in token depends on the business requirement
  // Input 2 is the secret
  // The same secret will be used to decode tokens
  let token = jwt.sign(
    {
      userId: user._id.toString(),
      batch: "thorium",
      organisation: "FunctionUp",
    },
    "functionup-radon"
  );
  res.setHeader("x-auth-token", token);
  res.send({ status: true, token: token });
};




// <---------Post a new product through category Id #findById -------------->
router.post(`/`, async (req, res) =>{
  const category = await Category.findById(req.body.category);
  if(!category) return res.status(400).send('Invalid Category')

  let product = new Product({
      name: req.body.name,
      description: req.body.description,
      richDescription: req.body.richDescription,
      image: req.body.image,
      brand: req.body.brand,
      price: req.body.price,
      category: req.body.category,
      countInStock: req.body.countInStock,
      rating: req.body.rating,
      numReviews: req.body.numReviews,
      isFeatured: req.body.isFeatured,
  })

  product = await product.save();

  if(!product) 
  return res.status(500).send('The product cannot be created')

  res.send(product);
})


// <---------PostRegister a New User-------------->
router.post('/', async (req,res)=>{
  let user = new User({
      name: req.body.name,
      email: req.body.email,
      passwordHash: bcrypt.hashSync(req.body.password, 10),
      phone: req.body.phone,
      isAdmin: req.body.isAdmin,
      street: req.body.street,
      apartment: req.body.apartment,
      zip: req.body.zip,
      city: req.body.city,
      country: req.body.country,
  })
  user = await user.save();

  if(!user)
  return res.status(400).send('the user cannot be created!')

  res.send(user);




// <---------PostRegister a New User-------------->
  router.post('/login', async (req,res) => {
    const user = await User.findOne({email: req.body.email})
    const secret = process.env.secret;
    if(!user) {
        return res.status(400).send('The user not found');
    }

    if(user && bcrypt.compareSync(req.body.password, user.passwordHash)) {
        const token = jwt.sign(
            {
                userId: user.id,
                isAdmin: user.isAdmin
            },
            secret,
            {expiresIn : '1d'}
        )
       
        res.status(200).send({user: user.email , token: token}) 
    } else {
       res.status(400).send('password is wrong!');
    }

    
})






// <--------------Post Login a User & Creating a Token #findOne #bcrypt.compareSync #jwt.sign----------->
router.post('/login', async (req,res) => {
  const user = await User.findOne({email: req.body.email})
  const secret = process.env.secret;
  if(!user) {
      return res.status(400).send('The user not found');
  }

  if(user && bcrypt.compareSync(req.body.password, user.passwordHash)) {
      const token = jwt.sign(
          {
              userId: user.id,
              isAdmin: user.isAdmin
          },
          secret,
          {expiresIn : '1d'}
      )
     
      res.status(200).send({user: user.email , token: token}) 
  } else {
     res.status(400).send('password is wrong!');
  }

  
})







// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>
// <<<<<<<<<<<<< GET >>>>>>>>>>>>>>>>
// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>





// <---------Get Category List #find-------------->
router.get(`/`, async (req, res) =>{
  const categoryList = await Category.find();

  if(!categoryList) {
      res.status(500).json({success: false})
  } 
  res.status(200).send(categoryList);
})





// <---------Get Category #findById------------>
router.get('/:id', async(req,res)=>{
  const category = await Category.findById(req.params.id);

  if(!category) {
      res.status(500).json({message: 'The category with the given ID was not found.'})
  } 
  res.status(200).send(category);
})





// <---------Get User Data #token #jwt.verify #findById-------------->
const getUserData = async function (req, res) {
  let token = req.headers["x-Auth-token"];
  if (!token) token = req.headers["x-auth-token"];

  //If no token is present in the request header return error
  if (!token) return res.send({ status: false, msg: "token must be present" });

  console.log(token);
  
  // If a token is present then decode the token with verify function
  // verify takes two inputs:
  // Input 1 is the token to be decoded
  // Input 2 is the same secret with which the token was generated
  // Check the value of the decoded token yourself
  let decodedToken = jwt.verify(token, "functionup-radon");
  if (!decodedToken)
    return res.send({ status: false, msg: "token is invalid" });

  let userId = req.params.userId;
  let userDetails = await userModel.findById(userId);
  if (!userDetails)
    return res.send({ status: false, msg: "No such user exists" });

  res.send({ status: true, data: userDetails });
};




// <---------Get Product by #findById #populate------------>
router.get(`/:id`, async (req, res) =>{
  const product = await Product.findById(req.params.id).populate('category');

  if(!product) {
      res.status(500).json({success: false})
  } 
  res.send(product);
})

// <---------Get Product by #find #select------------>
router.get('/', async (req,res) =>{
  const productList = await Product.find().select('name image -_id');

  if(!productList) {
    res.status(500).json({success: false})
  }
  res.send(productList);
})




// <---------Get Product count for statistical purpose #countDocuments------------>
router.get(`/get/count`, async (req, res) =>{
  const productCount = await Product.countDocuments((count) => count)

  if(!productCount) {
      res.status(500).json({success: false})
  } 
  res.send({
      productCount: productCount
  });
})




// <---------Get `@Featured` Products in desired counts  #find #limit ------------>
router.get(`/get/featured/:count`, async (req, res) =>{
  const count = req.params.count ? req.params.count : 0
  const products = await Product.find({isFeatured: true}).limit(+count);

  if(!products) {
      res.status(500).json({success: false})
  } 
  res.send(products);
})




// <---------Get Filtering and Getting Products Category #split #find #populate------------>
router.get(`/`, async (req, res) =>{
  // localhost:3000/api/v1/products?categories=2342342,234234
  let filter = {};
  if(req.query.categories)
  {
       filter = {category: req.query.categories.split(',')}
  }

  const productList = await Product.find(filter).populate('category');

  if(!productList) {
      res.status(500).json({success: false})
  } 
  res.send(productList);
})




// <---------Get User details excluting password #findbyId #select---------->
router.get('/:id', async(req,res)=>{
  const user = await User.findById(req.params.id).select('-passwordHash');

  if(!user) {
      res.status(500).json({message: false})
  } 
  res.status(200).send(user);
})





// <---------Get User details by id excluting password #findbyId #select---------->
router.get('/:id', async(req,res)=>{
  const user = await User.findById(req.params.id).select('-passwordHash');

  if(!user) {
      res.status(500).json({message: 'The user with the given ID was not found.'})
  } 
  res.status(200).send(user);
})


// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>
// <<<<<<<<<<< PUT >>>>>>>>>>>>>>>>
// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>




// <---------Put Udate user #findById #findOneAndUpdate----------->
const updateUser = async function (req, res) {
// Do the same steps here:
// Check if the token is present
// Check if the token present is a valid token
// Return a different error message in both these cases

  let userId = req.params.userId;
  let user = await userModel.findById(userId);
  //Return an error if no user with the given id exists in the db
  if (!user) {
    return res.send("No such user exists");
  }

  let userData = req.body;
  let updatedUser = await userModel.findOneAndUpdate({ _id: userId }, userData);
  res.send({ status: updatedUser, data: updatedUser });
};




// <---------Put Udate the category findByIdAndUpdate------->
router.put('/:id',async (req, res)=> {
  const category = await Category.findByIdAndUpdate(
      req.params.id,
      {
          name: req.body.name,
          icon: req.body.icon || category.icon,
          color: req.body.color,
      },
      { new: true}
  )

  if(!category)
  return res.status(400).send('the category cannot be created!')

  res.send(category);
})




// <---------Put Udate the product link categoryid #findByIdAndUpdate #isValidObjectId #findById------->
router.put('/:id',async (req, res)=> {
  if(!mongoose.isValidObjectId(req.params.id)) {
     return res.status(400).send('Invalid Product Id')
  }
  const category = await Category.findById(req.body.category);
  if(!category) return res.status(400).send('Invalid Category')

  const product = await Product.findByIdAndUpdate(
      req.params.id,
      {
          name: req.body.name,
          description: req.body.description,
          richDescription: req.body.richDescription,
          image: req.body.image,
          brand: req.body.brand,
          price: req.body.price,
          category: req.body.category,
          countInStock: req.body.countInStock,
          rating: req.body.rating,
          numReviews: req.body.numReviews,
          isFeatured: req.body.isFeatured,
      },
      { new: true}
  )

  if(!product)
  return res.status(500).send('the product cannot be updated!')

  res.send(product);
})



// <---------Put Hashing the User Password----------->
router.put('/:id',async (req, res)=> {

  const userExist = await User.findById(req.params.id);
  let newPassword
  if(req.body.password) {
      newPassword = bcrypt.hashSync(req.body.password, 10)
  } else {
      newPassword = userExist.passwordHash;
  }



// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>
// <<<<<<<<<<< DELETE >>>>>>>>>>>>>>>>
// <<<<<<<<<<<<><><><>>>>>>>>>>>>>>>>




// <---------Delete a category----------->

//  /api/v1/categories/:id 
router.delete('/:id', (req, res)=>{
  CategoryModel.findByIdAndRemove(req.params.id).then(category =>{
      if(category) {
          return res.status(200).json({success: true, message: 'the category is deleted!'})
      } else {
          return res.status(404).json({success: false , message: "category not found!"})
      }
  }).catch(err=>{
     return res.status(500).json({success: false, error: err}) 
  })
})




// <---------Delete a Product and validate Id #findByIdAndRemove----------->
router.delete('/:id', (req, res)=>{
  Product.findByIdAndRemove(req.params.id).then(product =>{
      if(product) {
          return res.status(200).json({success: true, message: 'the product is deleted!'})
      } else {
          return res.status(404).json({success: false , message: "product not found!"})
      }
  }).catch(err=>{
     return res.status(500).json({success: false, error: err}) 
  })
})















































































































































module.exports.createUser = createUser;
module.exports.getUserData = getUserData;
module.exports.updateUser = updateUser;
module.exports.loginUser = loginUser;
