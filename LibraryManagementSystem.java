import java.util.*;

// Book class
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

// User class
class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User[" + userId + "] " + name + " | Borrowed: " + borrowedBooks.size() + " books";
    }
}

// Library class
class Library {
    private Map<Integer, Book> books;
    private Map<Integer, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) { books.put(book.getBookId(), book); }
    public void addUser(User user) { users.put(user.getUserId(), user); }

    public void issueBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued!");
            return;
        }

        book.issue();
        user.borrowBook(book);
        System.out.println(user.getName() + " issued: " + book.getTitle());
    }

    public void returnBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("Invalid book or user!");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("This book was not issued!");
            return;
        }

        book.returnBook();
        user.returnBook(book);
        System.out.println(user.getName() + " returned: " + book.getTitle());
    }

    public void showBooks() {
        System.out.println("\n--- Book List ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        System.out.println("\n--- User List ---");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}

// Main class
public class LibraryManagementSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Add sample books
        library.addBook(new Book(1, "Automic Habits", "James Clear"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        // Add sample users
        library.addUser(new User(101, "Alice"));
        library.addUser(new User(102, "Bob"));

        int choice;
        do {
            System.out.println("\n====== Library Menu ======");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    library.showUsers();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    library.issueBook(bId, uId);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    uId = sc.nextInt();
                    library.returnBook(bId, uId);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
