# Assignment #2: Library Management System
## Description:
This library management system is designed to help librarians effectively manage books, patrons, and transactions. It provides a user-friendly interface for performing various library operations.

## Specifications
1. **Book Management**

    This system allows librarians to add a variety of books. Each book has attributes such as ISBN, title, author, genre, and availability status. Specialized types of books, such as FictionBook and NonFictionBook, are automatically created and sorted along with lists of specific book authors or genres.

2.  **Patron Management**

    Librarians can register patrons with attributes like ID, name, contact information, and borrowing history. Specialized types of patrons, such as StudentPatron and FacultyPatron, can be created with privileges or restrictions by simply applying during registration using inheritance.

3. **Transaction Management**

    This system manages transactions representing borrowing transactions between patrons and books. Transactions are associated with specific books and patrons using composition and encapsulation is applied to maintain transaction data integrity and ensure consistency.

4. **Library Management**

    The Library class manages overall library operations, including adding books, registering patrons, handling transactions, and applying simple search features. Polymorphism allows flexible handling of various library objects (books, patrons, transactions) through common interfaces while hiding implementation details.

9. **User Interface**
 
    Finally, this system provides a user interface (console-based) for librarians to interact with. Functionalities include adding books, registering patrons, checking out books, and returning books. Abstraction is used to separate user interface logic from the underlying business logic of the system, allowing only necessary data to be shown.

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
