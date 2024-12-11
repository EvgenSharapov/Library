package entity;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private final List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список книг ").append(books.getFirst().getAuthor()).append(" :\n");
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}

