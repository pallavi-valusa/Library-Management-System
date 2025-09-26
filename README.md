# Library-Management-System
This program is a console-based Library Management System developed in Java using Object-Oriented Programming (OOP) concepts. It manages books and users while providing functionality to issue and return books.
Classes Used

Book

Represents a book in the library.

Attributes:

bookId → unique identifier

title → name of the book

author → book’s author

isIssued → availability status

Methods: issue(), returnBook(), toString().

User

Represents a library user.

Attributes:

userId → unique identifier

name → user’s name

borrowedBooks → list of books the user has borrowed

Methods: borrowBook(), returnBook(), toString().

Library

Acts as the controller between Book and User.

Attributes:

A collection of all books (Map<Integer, Book>)

A collection of all users (Map<Integer, User>)

Methods:

addBook() → add a new book

addUser() → register a new user

issueBook() → issue a book to a user

returnBook() → return an issued book

showBooks() → display all books

showUsers() → display all users

LibrarySystem (Main class)

Provides a menu-driven interface for user interaction.

Lets users select options:

Show Books

Show Users

Issue Book

Return Book

Exit

🔹 Workflow

The system preloads some books and users.

A menu is displayed for the user.

The user can:

View all books and their availability.

View registered users.

Issue a book (if available).

Return a book (if already issued).

The program runs in a loop until the user selects Exit.
