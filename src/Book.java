public class Book {
    public String title;
    public String genre;
    public String author;
    public String publishing;
    public String publishingYear;
    public String ISBN;
    public int pages;
    public String Language;
    private boolean available;
    private String takenDate;
    private String returnDate;
    private int takenPeriod;
    private int countOfTaken;

    Book(String title, String genre, String author, String publishing, String publishingYear
            , String ISBN, int pages, String Language, boolean available, String takenDate,
         String returnDate, int takenPeriod, int countOfTaken) {
        this.title = title;
        this.genre = genre;
        this.author = author;
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

    public String getTakenDate(){
        return takenDate;
    }

    public void setTakenDate(String takenDate){
        this.takenDate = takenDate;
    }

    public String getReturnDate(){
        return returnDate;
    }

    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }

    public int getTakenPeriod(){
        return takenPeriod;
    }

    public void setTakenPeriod(int takenPeriod){
        this.takenPeriod = takenPeriod;
    }

    public int getCountOfTaken(){
        return countOfTaken;
    }

    public void setCountOfTaken(int countOfTaken){
        this.countOfTaken = countOfTaken;
    }
}
