const fs = require("fs");

const data = "Hello World!, I am Arpit Saxena\nThis is the new line";

function fileOperatios() {
  fs.writeFile("hello.txt", data, (err) => {
    if (err) {
      console.error("Error writing file:", err);
      return;
    }
    console.log("File written successfully!");

    fs.readFile("hello.txt", "utf-8", (err, fileData) => {
      if (err) {
        console.error("Error reading file:", err);
        return;
      }
      console.log("File content:", fileData);
    });
  });
}

fileOperatios();
