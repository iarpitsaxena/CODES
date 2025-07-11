const fs = require("fs");

// Path to the student.json file
const filePath = "./students.json";

// Read the student.json file
fs.readFile(filePath, "utf8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  try {
    // Parse the JSON data
    const students = JSON.parse(data);

    // Log details for each student
    students.forEach((student) => {
      console.log(`Name: ${student.name}`);
      console.log(`Age: ${student.age}`);
      console.log(`Grade: ${student.grade}`);
      console.log("-----------------------");
    });
  } catch (parseError) {
    console.error("Error parsing JSON data:", parseError);
  }
});
