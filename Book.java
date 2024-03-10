import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private boolean availability;

    public Book(String isbn, String title, String author, String genre, boolean availability) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

// Fiction
class FictionBook extends Book {
    private String topic; // Action, Horror, Thriller, etc.

    public FictionBook(String isbn, String title, String author, String genre, boolean availability, String topic) {
        super(isbn, title, author, genre, availability);
        this.topic = topic;
    }

    public String getFictionType() {
        return topic;
    }

    public void setFictionType(String fictionType) {
        this.topic = fictionType;
    }
}

// NonFiction
class NonFictionBook extends Book {
    private String topic;

    public NonFictionBook(String isbn, String title, String author, String genre, boolean availability, String topic) {
        super(isbn, title, author, genre, availability);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

class Author {
    private String name;
    private List<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}

class Genre {
    private String name;
    private List<Book> books;

    public Genre(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}