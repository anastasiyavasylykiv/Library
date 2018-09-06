package com.sombra.library.service;

import com.sombra.library.entity.Book;
import com.sombra.library.entity.Genre;

import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiya Vasylykiv
 */
public interface BookService {

    Book saveBook(Book author);

    Optional<Book> findById(Integer id);

    void removeBookById(Integer id);

    List<Book> findAll();

    List<Book> findAllWithAuthorHasManyBooks();

    Long countByGenre(Genre genre);
}
