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

    private static void option(){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("1.Add book");
            System.out.println("2.Remove book");
            System.out.println("3.Search book");
            System.out.println("4.Renewal book");
            System.out.println("5.List with books");
            System.out.println("6.Exit");

            String option = sc.nextLine();

            switch(option){
                case "Add book", "1"-> addBook();
            }
        }
    }

    private static void addBook(){
        String title;
        String authors;
        String publishing;
        int publishingYear;
        String ISBN;
        int pages;
        boolean isAvailable = false;
        int countOfTaken;
        String available;



        try(Scanner sc = new Scanner(System.in)){
            do{
                System.out.print("Enter title of book: ");
                title = sc.nextLine();
            }while(!Book.validateTitle(title));
            do{
                System.out.print("Enter author/s: ");
                authors = sc.nextLine();
            }while(!Book.validateAuthor(authors));
            do{
                System.out.print("Enter publishing: ");
                publishing = sc.nextLine();
            }while(!Book.validatePublishing(publishing));
            do{
                System.out.print("Enter publishing year: ");
                publishingYear = Integer.parseInt(sc.nextLine());
            }while(!Book.validatePublishingYear(publishingYear));
            do{
                System.out.print("Enter ISBN number: ");
                ISBN = sc.nextLine();
            }while(!Book.validateISBN(ISBN));
            do{
                System.out.print("Enter number of pages: ");
                pages = Integer.parseInt(sc.nextLine());
            }while(!Book.validatePages(pages));
            System.out.print("Is the book available? (yes/no):");
            available = sc.nextLine();
            if(available.equals("yes")){
                isAvailable = true;
            }
            do{
                System.out.print("Enter count of taken: ");
                countOfTaken = Integer.parseInt(sc.nextLine());
            }while(!Book.validateCountOfTaken(countOfTaken));
            
            Book book = new Book(title, authors, publishing, publishingYear, ISBN, pages, isAvailable,countOfTaken);
            books.add(book);
            System.out.println("The book is added!");
            option();
        }
    }
}