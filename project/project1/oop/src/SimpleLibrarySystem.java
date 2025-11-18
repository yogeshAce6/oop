import java.util.*;

// Book class
class Book {
    String id;
    String title;
    boolean isIssued;

    Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String toString() {
        return id + " - " + title + (isIssued ? " (Issued)" : " (Available)");
    }
}

// Custom Exception
class BookNotAvailableException extends Exception {
    BookNotAvailableException(String msg) {
        super(msg);
    }
}

// Library class
class Library {
    HashMap<String, Book> books = new HashMap<>();

    void addBook(String id, String title) {
        books.put(id, new Book(id, title));
        System.out.println("Book added successfully!");
    }

    void issueBook(String id) throws BookNotAvailableException {
        Book book = books.get(id);
        if (book == null)
            throw new BookNotAvailableException("Book ID not found!");
        if (book.isIssued)
            throw new BookNotAvailableException("Book already issued!");
        book.isIssued = true;
        System.out.println("Book issued successfully!");
    }

    void returnBook(String id) throws BookNotAvailableException {
        Book book = books.get(id);
        if (book == null || !book.isIssued)
            throw new BookNotAvailableException("Invalid return!");
        book.isIssued = false;
        System.out.println("Book returned successfully!");
    }

    void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }
}
public class SimpleLibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        library.addBook(id, title);
                    }
                    case 2 -> library.showBooks();
                    case 3 -> {
                        System.out.print("Enter Book ID to issue: ");
                        String id = sc.nextLine();
                        library.issueBook(id);
                    }
                    case 4 -> {
                        System.out.print("Enter Book ID to return: ");
                        String id = sc.nextLine();
                        library.returnBook(id);
                    }
                    case 5 -> {
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
