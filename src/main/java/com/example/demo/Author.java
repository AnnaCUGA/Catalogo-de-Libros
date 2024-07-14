package com.example.library.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date birthDate;
    private Date deathDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}

//un autor se compone de su id, sus libros, nombre, fecha de nacimiento y fallecimiento
