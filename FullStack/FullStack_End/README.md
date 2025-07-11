# Book Management Application

A full-stack web application for managing books with user authentication and CRUD operations.

## Features

- User authentication (register, login, logout)
- Book management (create, read, update, delete)
- Bootstrap-based responsive UI
- Form validation
- Session management
- MongoDB database integration

## Prerequisites

- Node.js (v14 or higher)
- MongoDB (v4.4 or higher)
- npm or yarn

## Installation

1. Clone the repository:

```bash
git clone <repository-url>
cd book-management-app
```

2. Install dependencies:

```bash
npm install
```

3. Make sure MongoDB is running on your system:

```bash
mongod
```

4. Start the application:

```bash
npm start
```

For development with auto-reload:

```bash
npm run dev
```

The application will be available at `http://localhost:3000`

## Project Structure

```
book-management-app/
├── models/
│   ├── user.js
│   └── book.js
├── routes/
│   ├── userRoutes.js
│   └── bookRoutes.js
├── views/
│   ├── layout.ejs
│   ├── users/
│   │   ├── login.ejs
│   │   └── register.ejs
│   └── books/
│       ├── index.ejs
│       ├── new.ejs
│       ├── edit.ejs
│       └── show.ejs
├── public/
│   └── css/
│       └── style.css
├── app.js
└── package.json
```

## API Routes

### User Routes

- GET /register - Registration form
- POST /register - Create new user
- GET /login - Login form
- POST /login - User login
- GET /logout - User logout

### Book Routes

- GET /books - List all books
- GET /books/new - New book form
- POST /books - Create new book
- GET /books/:id - Show book details
- GET /books/:id/edit - Edit book form
- PUT /books/:id - Update book
- DELETE /books/:id - Delete book

## Security Features

- Password hashing using bcrypt
- Session-based authentication
- Form validation
- Protected routes for authenticated users

## Technologies Used

- Node.js
- Express.js
- MongoDB with Mongoose
- EJS templating
- Bootstrap 5
- Passport.js for authentication
- Express-session for session management
