package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {


    private String title;
    private String author;
    private int year;
    private static final int DEFAULT_YEAR=2024;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year=DEFAULT_YEAR;
    }
}
