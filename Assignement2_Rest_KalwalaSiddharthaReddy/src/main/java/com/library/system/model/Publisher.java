package com.library.system.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publisher {

    @Id
    private Long pubId;

    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore 
    private List<Book> books;

    public Publisher() {}

    public Publisher(Long pubId, String name, String address) {
        this.pubId = pubId;
        this.name = name;
        this.address = address;
    }

    public Long getPubId() { return pubId; }
    public void setPubId(Long pubId) { this.pubId = pubId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
