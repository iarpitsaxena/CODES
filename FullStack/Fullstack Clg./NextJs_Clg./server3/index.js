// const express = require("express");

// const app = express();

// app.get("/", (req, res) => {
//   const name = req.query.name;
//   if (name) {
//     res.send(`Hello, ${name}!`);
//   } else {
//     res.send("Hello, World!");
//   }
// });

// app.get("/contact", (req, res) => {
//   res.send("Contact Page!!");
// });

// app.listen(5001, () => {
//   console.log(`Server is running at http://localhost:5000`);
// });

const express = require("express");
const app = express();

const PORT = 8005;
const data = require("./MOCK_DATA.json");

app.get("/", (req, res) => {
  res.send("Hello World!");
});

// app.get("/employees", (req, res) => {
//   const name = req.query.name;
//   if (name) {
//     const employee = data.find((emp) => emp.first_name === name);
//     res.json(employee);
//   }
//   //   res.json(employee);
// });
app.get("/employees", (req, res) => {
  const id = req.query.id;
  if (id) {
    const employee = data.find((emp) => emp.id == id);
    console.log(employee);
    res.json(employee);
  }

  //   res.json(employee);
});

app.get("employees/:id", (req, res) => {
  const id = req.params.id;
  if (id) {
    const employee = data.find((emp) => emp.id == id);
    console.log(employee);
    res.json(employee);
  }
});

app.listen(PORT, () => {
  console.log(`Server is running at http://localhost:${PORT}`);
});
