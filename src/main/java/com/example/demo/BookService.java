package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    //busca libros por título 
    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    //lista libros
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    //encuentra libros por el idioma en que están
    public List<Book> findBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    //libros por título parecido
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    //top 5 de libros
    public List<Book> findTop5MostPopularBooks() {
        return bookRepository.findTop5ByOrderByPopularityDesc();
    }

    //top 10 libros
    public List<Book> findTop10MostDownloadedBooks() {
        return bookRepository.findTop10ByOrderByDownloadsDesc();
    }
}
