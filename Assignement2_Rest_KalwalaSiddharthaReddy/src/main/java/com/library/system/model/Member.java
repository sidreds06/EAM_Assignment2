package com.library.system.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    private Long membId;

    private String name;
    private String address;
    private String membType;
    private LocalDate membDate;
    private LocalDate expiryDate;

    public Member() {}

    public Member(Long membId, String name, String address, String membType, LocalDate membDate, LocalDate expiryDate) {
        this.membId = membId;
        this.name = name;
        this.address = address;
        this.membType = membType;
        this.membDate = membDate;
        this.expiryDate = expiryDate;
    }

    public Long getMembId() { return membId; }
    public void setMembId(Long membId) { this.membId = membId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMembType() { return membType; }
    public void setMembType(String membType) { this.membType = membType; }

    public LocalDate getMembDate() { return membDate; }
    public void setMembDate(LocalDate membDate) { this.membDate = membDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
