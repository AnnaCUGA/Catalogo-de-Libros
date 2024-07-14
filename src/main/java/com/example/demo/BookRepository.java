package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//encontrará el libro buscando por idioma, título, si el título contiene cierta palabra, top 5 y toop 10 usando la cantidad de descargas
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    List<Book> findByLanguage(String language);
    List<Book> findByTitleContaining(String title);
    List<Book> findTop5ByOrderByPopularityDesc();
    List<Book> findTop10ByOrderByDownloadsDesc();
}
