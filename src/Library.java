import java.util.ArrayList;
import java.util.List;

public class Library {
    public String libraryName;
    public String address;
    private int numberOfEmployees;
    private final List<Book> listOfBooks = new ArrayList<>();

    Library(String libraryName, String address, int numberOfEmployees) {
        this.libraryName = libraryName;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
    }

    public static boolean validateLibraryName(String libraryName) {
        if(libraryName == null || libraryName.isBlank()){
            System.out.println("Library name cannot be empty.");
            return false;
        }
        if(libraryName.length() > 100){
            System.out.println("The library name cannot be longer than 100 characters.");
            return false;
        }
        return true;
    }

    public static boolean validateAddress(String address){
        if(address.isBlank()){
            System.out.println("Address cannot be empty");
            return false;
        }
        if(address.length() > 500){
            System.out.println("The address cannot be longer than 500 characters.");
            return false;

        }
        return true;
    }

    public static boolean validateNumberOfEmployees(int numberOfEmployees){
        if(numberOfEmployees <= 0 || numberOfEmployees >= 50){
            System.out.println("The number of library employees must be greater than 0 and less than 10! Please try again!");
            return false;
        }
        return true;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(Book book) {
        this.listOfBooks.add(book);
    }
}
