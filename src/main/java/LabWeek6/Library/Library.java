package LabWeek6.Library;
import java.util.ArrayList;

public class Library{
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book newBook){
        books.add(newBook);
    }

    public void printBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }

    public ArrayList<Book> searchByTitle(String searchedTitle) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (StringUtils.included(book.getTitle(), searchedTitle)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public ArrayList<Book> searchByPublisher(String publisher){
        ArrayList<Book> foundPublisher = new ArrayList<Book>();

        for(Book book : books){
            if (book.getPublisher().equals(publisher)){
                foundPublisher.add(book);
            }
        }

        return foundPublisher;
    }

    public ArrayList<Book> searchByYear(int year){
        ArrayList<Book> foundYear = new ArrayList<Book>();

        for(Book book : books){
            if (book.getYear() == year){
                foundYear.add(book);
            }
        }

        return foundYear;
    }

    public static void main(String[] args) {
        Library Library = new Library();

        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        Library.printBooks();


        ArrayList<Book> result = Library.searchByTitle("Cheese");
        for (Book book: result) {
            System.out.println(book);
        }


        System.out.println("---");
        for (Book book: Library.searchByPublisher("Penguin Group   ")) {
            System.out.println(book);
        }


        System.out.println("---");
        for (Book book: Library.searchByYear(1851)) {
            System.out.println(book);
        }

    }
}

class StringUtils {
    public static boolean included(String word, String searched) {

        word = word.toUpperCase();
        searched = searched.trim().toUpperCase();

        return word.contains(searched);
    }
}