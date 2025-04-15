import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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

            UserInterface.option();
        }

    }

}