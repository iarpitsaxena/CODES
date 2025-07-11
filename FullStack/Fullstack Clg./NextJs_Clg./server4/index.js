const express = require("express");
const fs = require("fs");
const data = require("./MOCK_DATA.json");

const PORT = 5001;

const app = express();
app.use(express.json());
app.use((req, res, next) => {
  console.log("Middleware 1");
  next();
});
app.use((req, res, next) => {
  console.log("Middleware 2");
  next();
});

app.get("/", (req, res) => {
  res.send("Hello, World!");
});

app.get("/employees", (req, res) => {
  res.send(data);
});

app.get("/employees/:id", (req, res) => {
  const id = req.params.id;
  if (id) {
    const employee = data.find((emp) => emp.id == id);
    const html = `
            <h2>${employee.first_name}</h2>
        `;
    res.send(html);
  } else {
    res.json(data);
  }
});

app.post("/employees", async (req, res) => {
  const body = req.body;
  data.push(body);
  fs.writeFile("./MOCK_DATA.json", JSON.stringify(data, null, 2), (err) => {
    if (err) {
      return res.status(500).send("Error writing to file");
    }
    res.send("OK");
  });
  res.json(data);
});

app.patch("/employees/:id", (req, res) => {});
app.delete("/employees/:id", (req, res) => {});

app.listen(PORT, () => {
  console.log(`http://localhost:${PORT}`);
});
