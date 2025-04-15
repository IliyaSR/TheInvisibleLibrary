import java.util.Scanner;

public class UserInterface {
    protected static void option() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("1.Add book");
            System.out.println("2.Remove book");
            System.out.println("3.Search book");
            System.out.println("4.Update book");
            System.out.println("5.List with books");
            System.out.println("6.Exit");

            String option = sc.nextLine();

            while (!option.equals("6") && !option.equals("Exit")) {

                switch (option) {
                    case "Add book", "1" -> LibraryManager.addBook();
                    case "Remove book", "2" -> LibraryManager.removeBook();
                    case "Search book", "3" -> LibraryManager.searchBook();
                    case "Update book", "4" -> LibraryManager.updateBook();
                    case "List with books", "5" -> LibraryManager.listOfBooks();
                }
            }
        }
    }
}
