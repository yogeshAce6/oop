📚 Library Management System – Mini Project (Unit 1)

A simple Java command-line application that demonstrates Object-Oriented Programming (OOP), Collections Framework, and Exception Handling.
This mini-project fulfills the requirements of Unit 1 (Java OOP Concepts) for academic submission.

🎯 Objective

To build a Library Management System using:

Classes & Objects (OOP)

HashMap & Collections

Custom Exceptions

Menu-driven user input

File logging

The system allows users to add books, issue books, return books, and calculate late fees, while ensuring proper validations using custom exceptions.

📝 Project Description

This project consists of three main classes:

1. Book Class

Represents a book with:

Book ID

Title

Issue status

Methods to issue and return a book

2. Member Class

Represents a library member with:

Member ID

Name

3. Library Class

Handles main library operations:

Add a book

Add a member

Issue a book

Return a book

Calculate late fees

Display books

Log all operations to a text file

A HashMap is used to store book inventory, and another to store member information.

Custom exceptions like:

BookNotAvailableException

InvalidReturnException

are used to enforce rules such as preventing issuing already-issued books or returning books that were never issued.

SAMPLE OUTPUT:
![imageAlt]()
