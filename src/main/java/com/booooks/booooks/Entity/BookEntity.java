package com.booooks.booooks.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;
    private String isbn;
    private String genre; // Добавляем поле для хранения жанра книги


    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity; // Поле для маппинга связи с сущностью AuthorEntity
}
