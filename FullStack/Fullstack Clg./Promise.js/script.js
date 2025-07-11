// let condition = false;
// let prom = new Promise(function (resolve, reject) {
//   if (condition) {
//     resolve("success");
//   } else {
//     reject("fail");
//   }
// });

// console.log(prom);

// function prom(complete) {
//   return new Promise(function (resolve, reject) {
//     console.log("waiting");
//     if (complete) {
//       resolve("i am doneeee");
//     } else {
//       reject("fail");
//     }
//   });
// }
// let onFulfill = (result) => {
//   console.log(result);
// };

// let onReject = (error) => {
//   console.log(error);
// };

// // prom.then(onFulfill);
// // prom.catch(onReject); // catch is used to handle the error in promise

// prom(true).then(onFulfill).catch(onReject);

// Simulating multiple async operations
//

let p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
    console.log("first execution");
    resolve(10);
  }, 1 * 1000);
});

let p2 = new Promise((resolve, reject) => {
  setTimeout(() => {
    console.log("second execution");
    resolve(20);
  }, 2 * 1000);
});

let p3 = new Promise((resolve, reject) => {
  setTimeout(() => {
    console.log("third execution");
    resolve(30);
  }, 3 * 1000);
});

let totalSum = 0;
Promise.all([p1, p2, p3]).then((result) => {
  {
    for (var i in result) {
      totalSum += result[i];
    }
  }
});

Promise.all([p1, p2, p3])
  .then((values) => {
    console.log(values);
  })

  .catch((values) => {
    console.log("all promises are resolved");
  });

let xhtttpRequest = new XMLHttpRequest();
xhtttpRequest.onreadystatechange = function () {
  if (this.readyState == 4 && this.status == 200) {
    console.log(this.responseText);
  }
};
xhtttpRequest.open("GET", "filename.txt", true);
xhtttpRequest.send();
