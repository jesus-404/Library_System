# Assignment #2: Library Management System
## Description:
This library management system is designed to help librarians effectively manage books, patrons, and transactions. It provides a user-friendly interface for performing various library operations.

## Specifications
1. Book Management
The system allows librarians to add, remove, and update books.
Each book has attributes such as ISBN, title, author, genre, and availability status.
Specialized types of books, such as FictionBook and NonFictionBook, can be created using inheritance.
Relationships between books and other entities (authors, genres) are modeled using composition.

3.  Patron Management
Librarians can register patrons with attributes like ID, name, contact information, and borrowing history.
Specialized types of patrons, such as StudentPatron and FacultyPatron, can be created with specific privileges or restrictions using inheritance.

5. Transaction Management
The system manages transactions representing borrowing transactions between patrons and books.
Transactions are associated with specific books and patrons using composition.
Encapsulation is applied to maintain transaction data integrity and ensure consistency.

7. Library Management
The Library class manages overall library operations, including adding/removing books, registering patrons, and handling transactions.
Abstraction is utilized to define high-level methods and interfaces for library operations, hiding implementation details.
Polymorphism allows flexible handling of various types of library objects (books, patrons, transactions) through common interfaces.

9. User Interface
The system provides a user interface (console-based) for librarians to interact with.
Functionalities include adding books, registering patrons, checking out books, and returning books.
Abstraction is used to separate user interface logic from the underlying business logic of the system.

## Example Interaction
```
Welcome to the Library Management System!

Select an Option:
1. Add Book
2. Register Patron
3. Check out Book
4. Return Book
5. Exit

Enter your choice: 1

Enter ISBN: 123
Enter Title: Example Book
Enter Author: Test Author
Enter Genre: Fiction
The book was added Successfully!
```
