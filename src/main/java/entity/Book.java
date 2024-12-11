package entity;

import lombok.Getter;

@Getter

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private boolean isAvailable;
    private static final int DEFAULT_YEAR=2024;

    public Book(String title, String author, int year,boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable=isAvailable;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year=DEFAULT_YEAR;
        this.isAvailable=true;
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return '\''+title + '\'' +
                ", Автор : '" + author + '\'' +
                ", Год выпуска : " + year;
    }
}
