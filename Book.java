public class Book {
    private String title;
    private String author;

    // Parameterized constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Constructor with a default author
    public Book(String title) {
        this(title, "Unknown"); // Calls the parameterized constructor
    }

    public static void main(String[] args) {
        // Creating objects using constructors
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Python Programming");

        // Displaying book details
        System.out.println("Book 1: " + book1.title + " by " + book1.author);
        System.out.println("Book 2: " + book2.title + " by " + book2.author);
    }
}

