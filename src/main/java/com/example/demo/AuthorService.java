package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    //obtener los datos del autor, como su repositorio de libros
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }
    //saber en que año está vivo o muerto
    public List<Author> findAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthDateBeforeAndDeathDateAfter(year, year);
    }
    //encontrar autores por nombre
    public List<Author> findAuthorsByName(String name) {
        return authorRepository.findByNameContaining(name);
    }
}
