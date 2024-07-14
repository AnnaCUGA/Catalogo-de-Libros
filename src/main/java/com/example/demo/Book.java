package com.example.library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;
    private int downloads;
    private int popularity;
    //la clase libro se compone del título, idioma, descargas, popularidad y nombre del autor y su id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
