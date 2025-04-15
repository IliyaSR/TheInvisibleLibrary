# The Invisible Library

A console-based library management system created as part of a university OOP assignment. This Java project helps librarians manage books efficiently through intuitive command-line operations and data validations.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Assignment Requirements](#assignment-requirements)
- [Contributing](#contributing)

## Overview

This application allows users to:

- Register and manage a library
- Add, remove, search, and update books
- Track book borrowing and availability
- Use data validation to ensure consistency and correctness

All operations are performed through the console, with an interactive menu guiding the user through all available options.

## Features

- Create and configure a library with name, address, and employee count
- Add new books with detailed information
- Remove books by title or ISBN
- Search for books by title, author, year, or ISBN
- Update availability and borrowing details for books
- Display all books in a tabular console format
- Built-in input validations for both library and book data
- Clean OOP design using encapsulation and modular structure

## Getting Started

### Prerequisites

- Java JDK 17+
- IDE of your choice (e.g. IntelliJ, Eclipse) or command-line tools

### Clone the Repository

```bash
git clone https://github.com/IliyaSR/TheInvisibleLibrary.git
cd TheInvisibleLibrary

Compile and Run

Use your IDE or run the following command from terminal:
bash
Copy

javac Main.java
java Main

You will be prompted to set up the library and then presented with the main menu.
Usage

Upon launching the application, you'll go through these steps:

    Library Setup
    Input name, address, and employee count. Validation ensures proper input.

    Main Menu
    Copy

    1. Add Book
    2. Remove Book
    3. Search Book
    4. Update Book
    5. List All Books
    6. Exit

    Manage Books
    Add, remove, search by different fields, update availability and borrowing stats, or print all current entries.

Project Structure
Copy

/TheInvisibleLibrary
│
├── Book.java               // Class representing a book with all its properties
├── Library.java            // Class representing the library with list of books
├── LibraryManager.java     // Class representing CRUD operation over books     
├── UserInterface.java      // Class representig User Interface 
├── Main.java               // Main application

Assignment Requirements

This project satisfies the requirements from the university Java OOP homework, including:

    Proper use of OOP (classes, encapsulation, constructors, etc.)

    Console input/output and validations

    Full CRUD operations for books

    Clean code and file structure

    Compliance with validation and UI requirements

Contributing

This is a student assignment project and not open for external contributions at the moment. However, feel free to fork the repo and use it for learning or personal practice.


