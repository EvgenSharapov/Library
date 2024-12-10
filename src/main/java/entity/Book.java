package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {


    private String title;
    private String author;
    private int year;
    private boolean isAvailable;
    private static final int DEFAULT_YEAR=2024;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable=true;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year=DEFAULT_YEAR;
        this.isAvailable=true;
    }

    @Override
    public String toString() {
        return "Название книги : '" + title + '\'' +
                ", Автор : '" + author + '\'' +
                ", Год выпуска : " + year;
    }
}
