const express = require("express");
const mongoose = require("mongoose");
const session = require("express-session");
const passport = require("passport");
const MongoStore = require("connect-mongo");
const methodOverride = require("method-override");
const path = require("path");
const flash = require("connect-flash");

const app = express();

// Passport config
require("./config/passport")(passport);

// Connect to MongoDB
mongoose.connect("mongodb://localhost:27017/book-management", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

// Middleware
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(methodOverride("_method"));
app.use(express.static("public"));
app.set("view engine", "ejs");

// Session configuration
app.use(
  session({
    secret: "your-secret-key",
    resave: false,
    saveUninitialized: false,
    store: MongoStore.create({
      mongoUrl: "mongodb://localhost:27017/book-management",
    }),
    cookie: { maxAge: 1000 * 60 * 60 * 24 }, // 24 hours
  })
);

// Flash messages
app.use(flash());

// Passport middleware
app.use(passport.initialize());
app.use(passport.session());

// Global variables middleware
app.use((req, res, next) => {
  res.locals.user = req.user;
  res.locals.error = req.flash("error");
  res.locals.success = req.flash("success");
  next();
});

// Routes
const userRoutes = require("./routes/userRoutes");
const bookRoutes = require("./routes/bookRoutes");

app.use("/", userRoutes);
app.use("/books", bookRoutes);

// Home route
app.get("/", (req, res) => {
  res.redirect("/books");
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
