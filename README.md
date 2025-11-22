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
![imageAlt]( https://github.com/yogeshAce6/oop/blob/a9ca9a751f1873e6d7eb7e6c9334a3f28a8ca0f0/project/project1/Java%20learning%20%E2%80%93%20SimpleLibrarySystem.java%2018-11-2025%2015_43_49.png)

MINI PROJECT2:

.

🚀 Multi-Threaded Log Analyzer – Mini Project 2

A Java-based concurrent log analysis system that processes multiple log files in parallel using ExecutorService, Callable workers, Streams, and ConcurrentHashMap.
This project demonstrates advanced concepts in multithreading, concurrency, and parallel data processing.

🎯 Objective

To design and implement a scalable multi-threaded application that:

Processes multiple log files simultaneously

Uses thread pools (ExecutorService)

Applies Stream pipelines for filtering & aggregation

Ensures thread-safe counting using ConcurrentHashMap

Generates a summary of matched keywords

Measures & logs total execution time

This project meets the requirements of Unit 2: Multithreading & Streams.

📁 Project Requirements
Input

A folder path containing .txt log files (e.g., /logs)

Processing

Each file is analyzed by a separate worker thread

Worker implemented using Callable<Map<String, Integer>>

Main thread aggregates results using:

ConcurrentHashMap<String, Integer>

merge() for atomic updates

Concurrency

Uses:

ExecutorService (Fixed Thread Pool)

Future to collect results

Callable tasks for file analysis

Output

Sorted keyword summary printed to console

Summary written to result_summary.txt

Total execution time displayed

Total execution time displayed

SAMPLE OUTPUT:
![imageAlt]( https://github.com/yogeshAce6/oop/blob/04fe85cc9f448a55eb60aa0c87feb2bd1b5d5926/project/project1/Java%20learning%20%E2%80%93%20SimpleLibrarySystem.java%2018-11-2025%2015_49_25.png)


