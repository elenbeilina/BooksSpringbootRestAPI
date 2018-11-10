package com.belch.Books_spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bookmanager")
public class Book extends AuditModel{

    @Id
    @GeneratedValue(generator = "bookmanager_generator")
    @SequenceGenerator(
            name = "bookmanager_generator",
            sequenceName = "bookmanager_sequence",
            initialValue = 10
    )
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
