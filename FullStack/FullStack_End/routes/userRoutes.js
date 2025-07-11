const express = require("express");
const router = express.Router();
const passport = require("passport");
const User = require("../models/user");

router.get("/register", (req, res) => {
  res.render("users/register");
});

router.post("/register", async (req, res) => {
  try {
    const { username, password } = req.body;
    const user = new User({ username });
    await user.setPassword(password);
    await user.save();
    req.flash(
      "success",
      `Welcome to BookShelf, ${username}! Ready to start your reading journey?`
    );
    res.redirect("/login");
  } catch (error) {
    req.flash("error", "Oops! Something went wrong. Please try again.");
    res.redirect("/register");
  }
});

router.get("/login", (req, res) => {
  res.render("users/login");
});

router.post(
  "/login",
  passport.authenticate("local", {
    successRedirect: "/books",
    failureRedirect: "/login",
    failureFlash: true,
  })
);

router.get("/logout", (req, res) => {
  req.logout(function (err) {
    if (err) {
      return next(err);
    }
    req.flash(
      "success",
      "See you soon! Your bookshelf will be here when you return."
    );
    res.redirect("/");
  });
});

module.exports = router;
