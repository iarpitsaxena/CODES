//create a fn. that take two input and print the value closest to 100 using arrow function.

const readlineSync = require("readline-sync");

let a = readlineSync.question("Enter num 1: ");
let b = readlineSync.question("Enter num 2: ");
const newTask = (num1, num2) =>
  Math.abs(100 - num1) > Math.abs(100 - num2)
    ? console.log(num2)
    : console.log(num1);

a = Number(a);
b = Number(b);

newTask(a, b);
