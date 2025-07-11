const http = require("http");
const fs = require("fs");

const server = http.createServer((req, res) => {
  // console.log(`${Date.now()} new request`);
  // console.log(req.url);
  fs.appendFile(
    "log.txt",
    `${Date.now()}: New client request \t on ${req.url}\n`,
    (err) => {
      if (err) return;
    }
  );
  switch (req.url) {
    case "/":
      res.end("From / page");
      break;
    case "/about":
      res.end("From /about page");
      break;
    default:
      res.end("404 not found");
  }
});

server.listen(5001, () => {
  console.log("server is running");
});
