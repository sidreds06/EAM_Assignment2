package com.library.system.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issue;
    private LocalDate dueDate;
    private LocalDate returnDate;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Member member;

    public Borrow() {}

    public Borrow(LocalDate issue, LocalDate dueDate, LocalDate returnDate, Book book, Member member) {
        this.issue = issue;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.book = book;
        this.member = member;
    }

    public Long getId() { return id; }

    public LocalDate getIssue() { return issue; }
    public void setIssue(LocalDate issue) { this.issue = issue; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
}
