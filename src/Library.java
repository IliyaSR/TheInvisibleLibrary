import java.util.ArrayList;
import java.util.List;

public class Library {
    public String libraryName;
    public String address;
    private int numberOfEmployees;
    private final List<Book> listOfBooks = new ArrayList<>();

    Library(String libraryName, String address, int numberOfEmployees, Book currentBook){
        this.libraryName = libraryName;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.listOfBooks.add(currentBook);
    }

    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees){
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<Book> getListOfBooks(){
        return listOfBooks;
    }

    public void setListOfBooks(Book book){
        this.listOfBooks.add(book);
    }
}
