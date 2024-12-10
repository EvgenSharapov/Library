package util;

import entity.Book;
import repository.Library;


public class Main{
    private static final String STARS = "***********************";

    public static void main(String[] args) {
        Library repository = new Library();
        Book bookOne = new Book("Мастер и маргарита", "Михаил Булгаков");
        Book bookTwo = new Book("Вишнёвый сад", "Антон Чехов", 2018);
        repository.addBook(bookOne);
        repository.addBook(bookTwo);
        repository.printAvailableBooks();
        System.out.println(STARS);
        repository.displayInfo("Война и мир");
        System.out.println(STARS);
        repository.findBooksByAuthor("Жюль Верн");
        System.out.println(STARS);
        repository.borrowBook(bookOne);
        repository.borrowBook(bookTwo);
        repository.printAvailableBooks();
        System.out.println(STARS);
        repository.returnBook(bookOne);
        repository.returnBook(bookTwo);
        repository.printAvailableBooks();


    }

}
