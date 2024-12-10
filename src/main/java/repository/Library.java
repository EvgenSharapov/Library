package repository;
import entity.Book;
import java.util.ArrayList;
import java.util.List;

public class Library{
    private static final List<Book> BOOKS = new ArrayList<>();
    static {
        BOOKS.add(new Book("Война и мир", "Лев Толстой",2010 ));
        BOOKS.add(new Book("Таинственный остров", "Жюль Верн",2013 ));
        BOOKS.add(new Book("Преступление и наказание", "Фёдор Достоевский"));
        BOOKS.add(new Book("Всадник без головы", "Майн Рид",2017 ));
        BOOKS.add(new Book("Мёртвые Души", "Николай Гоголь" ));

    }

    public void borrowBook(Book book) {
        if(book.isAvailable()){book.setAvailable(false);}

    }

    public void returnBook(Book book) {
        book.setAvailable(true);

    }

    public void  printAvailableBooks(){
        System.out.println("Доступные книги :");
        BOOKS.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);

    }

    public void addBook(Book book) {
        BOOKS.add(book);

    }

    public void displayInfo(String title) {
        BOOKS.stream()
                .filter(book -> book.getTitle().equals(title))
                .forEach(System.out::println);
    }

    public void findBooksByAuthor(String author) {
        BOOKS.stream()
                .filter(book -> book.getAuthor().equals(author))
                .forEach(System.out::println);
    }
}
