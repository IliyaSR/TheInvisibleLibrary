import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    static List<Book> books = new ArrayList<>();

    protected static void addBook() {
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
            UserInterface.option();
        }
    }

    protected static void removeBook() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the name or ISBN number of the book you want to remove: ");
            String input = sc.nextLine().toLowerCase();
            Iterator<Book> iterator = books.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.title.toLowerCase().equals(input) || book.ISBN.equals(input)) {
                    iterator.remove();
                    System.out.println("Successfully removed the book!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Book not found!");
            }

            UserInterface.option();
        }
    }

    protected static void searchBook() {
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

    protected static void searchBookCriteria(String criteria, String input) {
        for (Book book : books) {
            if (getFieldValue(book, criteria).equals(input)) {
                System.out.printf("%-15s %-15s %-15s %-20s %-15s %-15s\n", "Title",
                        "Authors", "Publishing", "Publishing Year", "ISBN", "Pages");
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.printf("%-15s %-15s %-15s %-20d %-15s %-15s\n",
                        book.title, book.authors, book.publishing, book.publishingYear, book.ISBN, book.pages);
                UserInterface.option();
            } else {
                System.out.println("Not found book!");
                UserInterface.option();
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

    protected static void updateBook() {
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
                    UserInterface.option();
                } else {
                    System.out.println("The library doesn't have this book.");
                    UserInterface.option();
                }
            }
        }

    }

    protected static void listOfBooks() {
        if(books.isEmpty()){
            System.out.println("The library doesn't have books!");
        }else{
            for (Book book : books) {
                System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s %-10s %-15s\n", "Title", "Author",
                        "Publishing", "Publishing Year", "ISBN", "Pages", "Available", "Count of taken");
                System.out.println(book);
            }
        }
        UserInterface.option();
    }
}
