package org.example.springboottest.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String bookTitle;

    @Column(nullable = false, length = 100)
    private String bookAuthor;

    @Column(nullable = false)
    private String bookCategory;

    @Builder
    public Book(Long id, String bookTitle, String bookAuthor, String bookCategory) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
    }
}
