const fs = require("fs");
console.log("event1");
// const data = fs.readFileSync("enemies.txt", "utf-8");
fs.readFile("enemies.txt", "utf-8", (err, fileData) => {
  if (err) {
    console.log(err);
  }
  console.log(fileData);
});
// console.log(data);
console.log("event2");
