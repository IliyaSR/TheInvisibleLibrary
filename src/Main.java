import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Hello, please enter information about library!");
            String libraryName;
            String address;
            int numberOfEmployees;
            do {
                System.out.print("Enter library name: ");
                libraryName = sc.nextLine();
            } while (!Library.validateLibraryName(libraryName));
            do {
                System.out.print("Enter address: ");
                address = sc.nextLine();
            } while (!Library.validateAddress(address));
            do {
                System.out.print("Enter employees: ");
                numberOfEmployees = Integer.parseInt(sc.nextLine());
            } while (!Library.validateNumberOfEmployees(numberOfEmployees));

            Library library = new Library(libraryName, address, numberOfEmployees);

            option();
        }

    }

    private static void option() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("1.Add book");
            System.out.println("2.Remove book");
            System.out.println("3.Search book");
            System.out.println("4.Update book");
            System.out.println("5.List with books");
            System.out.println("6.Exit");

            String option = sc.nextLine();

            switch (option) {
                case "Add book", "1" -> addBook();
                case "Remove book", "2" -> removeBook();
                case "Search book", "3" -> searchBook();
                case "Update book", "4" -> updateBook();
            }
        }
    }

    private static void addBook() {
        String title;
        String authors;
        String publishing;
        int publishingYear;
        String ISBN;
        int pages;
        boolean isAvailable = false;
        int countOfTaken;
        String available;


        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.print("Enter title of book: ");
                title = sc.nextLine();
            } while (!Book.validateTitle(title));
            do {
                System.out.print("Enter author/s: ");
                authors = sc.nextLine();
            } while (!Book.validateAuthor(authors));
            do {
                System.out.print("Enter publishing: ");
                publishing = sc.nextLine();
            } while (!Book.validatePublishing(publishing));
            do {
                System.out.print("Enter publishing year: ");
                publishingYear = Integer.parseInt(sc.nextLine());
            } while (!Book.validatePublishingYear(publishingYear));
            do {
                System.out.print("Enter ISBN number: ");
                ISBN = sc.nextLine();
            } while (!Book.validateISBN(ISBN));
            do {
                System.out.print("Enter number of pages: ");
                pages = Integer.parseInt(sc.nextLine());
            } while (!Book.validatePages(pages));
            System.out.print("Is the book available? (yes/no):");
            available = sc.nextLine();
            if (available.equals("yes")) {
                isAvailable = true;
            }
            do {
                System.out.print("Enter count of taken: ");
                countOfTaken = Integer.parseInt(sc.nextLine());
            } while (!Book.validateCountOfTaken(countOfTaken));

            Book book = new Book(title, authors, publishing, publishingYear, ISBN, pages, isAvailable, countOfTaken);
            books.add(book);
            System.out.println("The book is added!");
            option();
        }
    }

    private static void removeBook() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the name or ISBN number of the book you want to remove: ");
            String input = sc.nextLine().toLowerCase();
            for (Book book : books) {
                if (book.title.toLowerCase().equals(input) || book.ISBN.equals(input)) {
                    books.remove(book);
                    System.out.println("Correctly remove book!");
                } else {
                    System.out.println("Book not found!");
                }
                option();
            }
        }
    }

    private static void searchBook() {
        String title;
        String author;
        String publishingYear;
        String ISBN;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter how you'd like to search for the book: by title, author, publishing year, or ISBN number: ");
            String searchWay = sc.nextLine().toLowerCase();
            switch (searchWay) {
                case ("title") -> {
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    searchBookCriteria("title", title);
                }
                case ("author") -> {
                    System.out.print("Enter author: ");
                    author = sc.nextLine();
                    searchBookCriteria("author", author);
                }
                case ("publishing year") -> {
                    System.out.print("Enter publishing year: ");
                    publishingYear = sc.nextLine();
                    searchBookCriteria("publishing year", publishingYear);
                }
                case ("isbn number") -> {
                    System.out.print("Enter ISBN number: ");
                    ISBN = sc.nextLine();
                    searchBookCriteria("ISBN", ISBN);
                }
            }
        }

    }

    private static void searchBookCriteria(String criteria, String input) {
        for (Book book : books) {
            if (getFieldValue(book, criteria).equals(input)) {
                System.out.printf("%-15s %-15s %-15s %-20s %-15s %-15s\n", "Title",
                        "Authors", "Publishing", "Publishing Year", "ISBN", "Pages");
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.printf("%-15s %-15s %-15s %-20d %-15s %-15s\n",
                        book.title, book.authors, book.publishing, book.publishingYear, book.ISBN, book.pages);
                option();
            } else {
                System.out.println("Not found book!");
                option();
            }
        }
    }

    private static String getFieldValue(Book book, String criteria) {
        return switch (criteria) {
            case "title" -> book.title.toLowerCase();
            case "author" -> book.authors.toLowerCase();
            case "publishing year" -> String.valueOf(book.publishingYear);
            case "ISBN" -> book.ISBN;
            default -> null;
        };
    }

    private static void updateBook() {
        try (Scanner sc = new Scanner(System.in)) {
            String isbn;
            do {
                System.out.print("Enter ISBN number: ");
                isbn = sc.nextLine();
            } while (!Book.validateISBN(isbn));

            for (Book book : books) {
                if (book.ISBN.equals(isbn)) {
                    System.out.printf("You chose to update the information for the book with ISBN number: %s\n", isbn);
                    System.out.println("Please choose what you'd like to update: ");
                    System.out.println("1. Availability");
                    System.out.println("2. Taken date");
                    System.out.println("3. Return date");
                    System.out.println("4. Period of taken");
                    System.out.println("5. Count of taken");
                    String inputOfUpdate = sc.nextLine();
                    switch (inputOfUpdate) {
                        case "Availability", "1" -> {
                            System.out.print("Update available (yes/no): ");
                            String available = sc.nextLine();
                            if (available.equals("yes")) {
                                book.setAvailableBook(true);
                            } else if (available.equals("no")) {
                                book.setAvailableBook(false);
                            }
                        }
                        case "Taken date", "2" -> {
                            System.out.print("Update taken date: ");
                            String takenDate = sc.nextLine();
                            book.setTakenDate(takenDate);
                        }
                        case "Return date", "3" -> {
                            System.out.print("Update return date: ");
                            String returnDate = sc.nextLine();
                            book.setReturnDate(returnDate);
                        }
                        case "Period of taken", "4" -> {
                            System.out.print("Update period of taken: ");
                            int periodOfTaken = Integer.parseInt(sc.nextLine());
                            book.setTakenPeriod(periodOfTaken);
                        }
                        case "Count of taken", "5" -> {
                            System.out.print("Update count of taken: ");
                            int countOfTaken = Integer.parseInt(sc.nextLine());
                            book.setCountOfTaken(countOfTaken);
                        }
                    }
                    option();
                } else {
                    System.out.println("The library doesn't have this book.");
                    option();
                }
            }
        }

    }
}