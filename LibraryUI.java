import java.util.Scanner;

public class LibraryUI {
    private Library library;
    private Scanner scanner;

    public LibraryUI() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the Library Management System!\n");
        System.out.println("Select an Option:");
        System.out.println("1. Add Book");
        System.out.println("2. Register Patron");
        System.out.println("3. Check Out Book");
        System.out.println("4. Return Book");
        System.out.println("5. Exit");
        System.out.println("6. Debug");
    }

    public void handleUserInput() {
        boolean exit = false;
        displayMenu();
        while (!exit) {
            System.out.print("\nEnter your choice: ");
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerPatron();
                    break;
                case 3:
                    checkOutBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    exit = true;
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        System.exit(0);
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addBook() {
        System.out.print("\nEnter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        Book book = new Book(isbn, title, author, genre, true);
        library.addBook(book);
        if (library.findAuthorByName(author) != null) {
            library.findAuthorByName(author).addBook(book);
        } else {
            library.addAuthor(author);
            library.findAuthorByName(author).addBook(book);
        }
        if (library.findGenreByName(genre) != null) {
            library.findGenreByName(genre).addBook(book);
        } else {
            library.addGenre(genre);
            library.findGenreByName(genre).addBook(book);
        }

        System.out.println("The book was added successfully!\n");
        handleUserInput();
    }

    private void registerPatron() {
        int id;
        System.out.print("\nEnter Patron Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patron Contact Info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Are You a Student or Faculty Patron? (student/faculty/none): ");
        String patronType = scanner.nextLine();
        if (patronType.equalsIgnoreCase("student") || patronType.equalsIgnoreCase("s")) {
            System.out.print("Enter a Student ID: ");
            id = getIntInput();
            library.addStudentPatron(name, contactInfo, id);
        } else if (patronType.equalsIgnoreCase("faculty") || patronType.equalsIgnoreCase("f")) {
            System.out.print("Enter a Faculty ID: ");
            id = getIntInput();
            library.addFacultyPatron(name, contactInfo, id);
        } else {
            library.addPatron(name, contactInfo);
        }

        System.out.println("Patron was registered successfully!\n");
        handleUserInput();
    }

    private void checkOutBook() {
        System.out.print("\nEnter Patron ID: ");
        int patronId = getIntInput();
        System.out.print("Enter Book ISBN: ");
        int num = getIntInput();
        String isbn = Integer.toString(num);

        if (library.findPatronById(patronId) == null || library.findBookByISBN(isbn) == null) {
            System.out.println("Invalid patron ID or book ISBN.");
            handleUserInput();
        }

        if (!library.findBookByISBN(isbn).isAvailable()) {
            System.out.println("Book is currently unavailable");
            handleUserInput();
        }

        library.borrowBook(patronId, isbn);
        System.out.println("The book was checked out successfully!\n");
        handleUserInput();
    }

    private void returnBook() {
        System.out.print("\nEnter Transaction ID: ");
        int transactionId = getIntInput();
        Transaction transaction = library.findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Invalid transaction ID.\n");
            handleUserInput();
        }

        Book book = transaction.getBook();
        if (book.isAvailable()) {
            System.out.println("Book is currently available");
            return;
        }

        library.returnBook(transactionId);
        System.out.println("The book was returned successfully!\n");
        handleUserInput();
    }
}
