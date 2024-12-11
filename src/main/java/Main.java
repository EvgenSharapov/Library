import entity.Book;
import repository.Library;

import java.util.Arrays;
import java.util.Optional;


public class Main{
    private static final String STARS = "***********************";

    public static void main(String[] args) {
        Library repository = new Library();
        Book bookOne = new Book("Мастер и маргарита", "Михаил Булгаков");
        Book bookTwo = new Book("Вишнёвый сад", "Антон Чехов", 2018,true);
        Optional<Book> bookTree=repository.getBook("Всадник без головы");
        repository.addBook(bookOne);
        repository.addBook(bookTwo);
        repository.printAvailableBooks();
        System.out.println(STARS);
        repository.displayInfo("Война и мир");
        System.out.println(STARS);

        (repository.findBooksByAuthor("Жюль Верн")).ifPresentOrElse(
                book -> System.out.print("" + book),
                () -> System.out.println("Такой автор не найден")
        );
        System.out.println(STARS);
        if(repository.borrowBook(bookOne)){
            System.out.printf("Книгу '%s' взяли из библиотеки.\n",bookOne.getTitle());
        };
        if(repository.borrowBook(bookTwo)){
            System.out.printf("Книгу '%s' взяли из библиотеки.\n",bookTwo.getTitle());
        };

        bookTree.ifPresent(book -> {
            if(repository.borrowBook(book)){System.out.printf("Книгу '%s' взяли из библиотеки.\n",book.getTitle());};;
        });
        System.out.println(STARS);
        repository.printAvailableBooks();
        System.out.println(STARS);
        if(repository.returnBook(bookOne)){System.out.printf("Книгу '%s' вернули в библиотеку.\n",bookOne.getTitle());}
        if(repository.returnBook(bookTwo)){System.out.printf("Книгу '%s' вернули в библиотеку.\n",bookTwo.getTitle());}
        System.out.println(STARS);
        repository.printAvailableBooks();


    }

}
