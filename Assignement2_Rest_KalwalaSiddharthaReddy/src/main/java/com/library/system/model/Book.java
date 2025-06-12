package com.library.system.model;

import com.library.system.model.Publisher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    private Long bookId;

    private String title;
    private String author;
    private Double price;
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties("books")
    private Publisher publisher;

    // Constructors
    public Book() {}

    public Book(Long bookId, String title, String author, Double price, Boolean available, Publisher publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
        this.publisher = publisher;
    }

    // Getters and Setters
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }
}
