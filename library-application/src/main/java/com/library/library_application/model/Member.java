package com.library.library_application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in MySQL
    private int memberId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    // Default constructor (required by JPA)
    public Member() {
    }

    // Parameterized constructor (developer convenience)
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Member m = new Member("Ramya", "johndoe@gmail.com");
        m.setName("John");
        System.out.println("Name: " + m.getName());
        System.out.println("Email: " + m.getEmail());
        System.out.println(m);
    }
}
