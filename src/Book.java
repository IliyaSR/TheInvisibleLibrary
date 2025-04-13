import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Book {
    public String title;
    public String genre;
    public String authors;
    public String publishing;
    public int publishingYear;
    public String ISBN;
    public int pages;
    public String Language;
    private boolean available;
    private String takenDate;
    private String returnDate;
    private int takenPeriod;
    private int countOfTaken;

    Book(String title, String authors, String publishing, int publishingYear, String ISBN, int pages
            , boolean available, int countOfTaken) {
        this.title = title;
        this.authors = authors;
        this.publishing = publishing;
        this.publishingYear = publishingYear;
        this.ISBN = ISBN;
        this.pages = pages;
        this.available = available;
        this.countOfTaken = countOfTaken;
    }

    Book(String title, String genre, String authors, String publishing, int publishingYear
            , String ISBN, int pages, String Language, boolean available, String takenDate,
         String returnDate, int takenPeriod, int countOfTaken) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.publishing = publishing;
        this.publishingYear = publishingYear;
        this.ISBN = ISBN;
        this.pages = pages;
        this.Language = Language;
        this.available = available;
        this.takenDate = takenDate;
        this.returnDate = returnDate;
        this.takenPeriod = takenPeriod;
        this.countOfTaken = countOfTaken;
    }

    public boolean getAvailableBook() {
        return available;
    }

    public void setAvailableBook(boolean available) {
        this.available = available;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getTakenPeriod() {
        return takenPeriod;
    }

    public void setTakenPeriod(int takenPeriod) {
        this.takenPeriod = takenPeriod;
    }

    public int getCountOfTaken() {
        return countOfTaken;
    }

    public void setCountOfTaken(int countOfTaken) {
        this.countOfTaken = countOfTaken;
    }

    public static boolean validateTitle(String title) {
        if (title.isBlank()) {
            System.out.println("Title of book cannot be empty.");
            return false;
        }
        if (title.length() > 100) {
            System.out.println("The title of book cannot be longer than 100 characters.");
            return false;
        }
        return true;
    }

    public static boolean validateAuthor(String authors) {
        String[] arrAuthors = authors.split(", ");
        for (String author : arrAuthors) {
            if (author.length() > 50) {
                System.out.println("The author name cannot be longer than 50 characters.");
                return false;
            }
            if (author.isBlank()) {
                System.out.println("Author name cannot be empty");
                return false;
            }
        }
        return true;
    }

    public static boolean validatePublishing(String publishing) {
        if (publishing.isBlank()) {
            System.out.println("Publishing of book cannot be empty.");
            return false;
        }
        if (publishing.length() > 50) {
            System.out.println("The publishing of book cannot be longer than 50 characters.");
            return false;
        }
        return true;
    }

    public static boolean validatePublishingYear(int publishingYear) {
        int currentYear = Year.now().getValue();

        if (publishingYear < 0) {
            System.out.println("The publishing year cannot be negative.");
            return false;
        }
        if (publishingYear > currentYear) {
            System.out.println("The publishing year cannot be greater than the current year.");
            return false;
        }
        return true;
    }

    public static boolean validateISBN(String ISBN) {
        if (ISBN.isBlank()) {
            System.out.println("ISBN number cannot be empty.");
            return false;
        }
        if (ISBN.length() > 10) {
            System.out.println("The ISBN number cannot be longer than 10 characters.");
            return false;
        }
        return true;
    }

    public static boolean validatePages(int pages) {
        if (pages < 0) {
            System.out.println("The pages cannot be negative.");
            return false;
        }
        return true;
    }

    public static boolean validateCountOfTaken(int countOfTaken) {
        if (countOfTaken < 0) {
            System.out.println("The count of taken cannot be negative");
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("%-10s %-10s %-10s %-15s %-10s %-10s %-10s %-15s", title, authors, publishing
                , publishingYear, ISBN, pages, available, countOfTaken);
    }
}
