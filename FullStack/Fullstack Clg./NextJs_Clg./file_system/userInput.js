//create a text file named as userdata.txt that takes user input name and email and write this information inside created file . each new user details appended to existing file
//  const fs = require('fs');
// const readline = require('readline');

// // Create a readline interface for user input
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout
// });

// // Prompt for user details
// rl.question('Enter your name: ', (name) => {
//   rl.question('Enter your email: ', (email) => {
//     // Prepare the user data to be written
//     const userData = `Name: ${name}\nEmail: ${email}\n`;

//     // Write data to 'user_data.txt'
//     fs.appendFile('user_data.txt', userData, (err) => {
//       if (err) {
//         console.error('Error writing to file:', err);
//       } else {
//         console.log('User data saved to user_data.txt');
//       }

//       // Close the readline interface
//       rl.close();
//     });
//   });
// });
