package com.library.library_application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in MySQL
    private int bookId;

    private String title;


    private String author;


    private boolean availableStatus = true;

    // Default constructor (required by JPA)
    public Book() {
    }


    public Book(String title, String author, boolean availableStatus) {
        this.title = title;
        this.author = author;
        this.availableStatus = availableStatus;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(boolean availableStatus) {
        this.availableStatus = availableStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availableStatus=" + availableStatus +
                '}';
    }

     //optional(terminal testing)
    public static void main(String[] args) {
        Book b=new Book("clean code","harry potter",true);
        System.out.println(b.getTitle());
        b.setAvailableStatus(false);
        System.out.println(b);
    }
}
