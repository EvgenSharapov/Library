package repository;
import entity.Book;
import entity.BookCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library{
    private static final List<Book> BOOKS = new ArrayList<>();
    static {
        BOOKS.add(new Book("Война и мир", "Лев Толстой",2010,true ));
        BOOKS.add(new Book("Таинственный остров", "Жюль Верн",2013,true ));
        BOOKS.add(new Book("Преступление и наказание", "Фёдор Достоевский"));
        BOOKS.add(new Book("Всадник без головы", "Майн Рид",2017,true ));
        BOOKS.add(new Book("Мёртвые Души", "Николай Гоголь" ));
        BOOKS.add(new Book("Дети капитана Гранта", "Жюль Верн",2015,true ));
    }


    public boolean borrowBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        if (!book.isAvailable()) {
            return false;
        }

        book.setAvailable(false);
        System.out.printf("Книгу '%s' взяли из библиотеки.\n",book.getTitle());
        return true;
    }

    public boolean returnBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        book.setAvailable(true);
        System.out.printf("Книгу '%s' вернули в библиотеку.\n",book.getTitle());
        return true;
    }

    public void  printAvailableBooks(){
        System.out.println("Доступные книги :");
        BOOKS.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);

    }

    public void addBook(Book book) {
        if(book != null){
        BOOKS.add(book);}

    }
    public Optional<Book> getBook(String title) {
        for (Book book : BOOKS) {
            if (book.getTitle().equals(title)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public void displayInfo(String title) {
        if (title != null) {
            List<Book> bookInfo = BOOKS.stream()
                    .filter(book -> book.getTitle().equals(title)).toList();
            if(bookInfo.isEmpty()){

                System.out.printf("Книга '%s' не найдена\n",title);
            }
            else System.out.println(bookInfo);
        }
    }

    public Optional<BookCollection> findBooksByAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        BookCollection bookCollection=new BookCollection();
        List<Book> collection = BOOKS.stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
        if(collection.isEmpty()){return Optional.empty();}
        for(Book book:collection){
            bookCollection.addBook(book);
        }
        return Optional.of(bookCollection);
    }
}
