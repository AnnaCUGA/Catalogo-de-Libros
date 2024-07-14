package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//el repositorio de autor consta de los caracteres que tiene su nombre, para hallar burdamente algún autor y las fechas de nacimiento y fallecimiento
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByNameContaining(String name);
    List<Author> findByBirthDateBeforeAndDeathDateAfter(int birthYear, int deathYear);
}
