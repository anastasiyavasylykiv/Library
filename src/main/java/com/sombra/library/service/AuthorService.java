package com.sombra.library.service;

import com.sombra.library.entity.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiya Vasylykiv
 */
public interface AuthorService {

    Author saveAuthor(Author author);

    Optional<Author> findById(Integer id);

    void removeAuthorById(Integer id);

    List<Author> findAll();

    List<Author> findAllAgeGreaterThan(Integer age);

}
