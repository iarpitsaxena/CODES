const express = require("express");
const router = express.Router();
const Book = require("../models/book");

router.get("/", async (req, res) => {
  try {
    const books = await Book.find({ user: req.user._id });
    res.render("books/index", { books });
  } catch (error) {
    req.flash("error", "Couldn't load your bookshelf. Please try again.");
    res.redirect("/");
  }
});

router.get("/new", (req, res) => {
  res.render("books/new");
});

router.post("/", async (req, res) => {
  try {
    const book = new Book({
      ...req.body,
      user: req.user._id,
    });
    await book.save();
    req.flash("success", "Book added to your shelf!");
    res.redirect("/books");
  } catch (error) {
    req.flash("error", "Couldn't add the book. Please try again.");
    res.redirect("/books/new");
  }
});

router.get("/:id", async (req, res) => {
  try {
    const book = await Book.findOne({
      _id: req.params.id,
      user: req.user._id,
    });
    if (!book) {
      req.flash("error", "Book not found.");
      return res.redirect("/books");
    }
    res.render("books/show", { book });
  } catch (error) {
    req.flash("error", "Couldn't load the book. Please try again.");
    res.redirect("/books");
  }
});

router.get("/:id/edit", async (req, res) => {
  try {
    const book = await Book.findOne({
      _id: req.params.id,
      user: req.user._id,
    });
    if (!book) {
      req.flash("error", "Book not found.");
      return res.redirect("/books");
    }
    res.render("books/edit", { book });
  } catch (error) {
    req.flash("error", "Couldn't load the book. Please try again.");
    res.redirect("/books");
  }
});

router.put("/:id", async (req, res) => {
  try {
    const book = await Book.findOneAndUpdate(
      { _id: req.params.id, user: req.user._id },
      req.body,
      { new: true }
    );
    if (!book) {
      req.flash("error", "Book not found.");
      return res.redirect("/books");
    }
    req.flash("success", "Book updated successfully!");
    res.redirect("/books");
  } catch (error) {
    req.flash("error", "Couldn't update the book. Please try again.");
    res.redirect("/books");
  }
});

router.delete("/:id", async (req, res) => {
  try {
    const book = await Book.findOneAndDelete({
      _id: req.params.id,
      user: req.user._id,
    });
    if (!book) {
      req.flash("error", "Book not found.");
      return res.redirect("/books");
    }
    req.flash("success", "Book removed from your shelf.");
    res.redirect("/books");
  } catch (error) {
    req.flash("error", "Couldn't delete the book. Please try again.");
    res.redirect("/books");
  }
});

module.exports = router;
