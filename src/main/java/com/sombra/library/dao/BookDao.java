package com.sombra.library.dao;

import com.sombra.library.entity.Book;
import com.sombra.library.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Anastasiya Vasylykiv
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    @Query("select b from Book b where size(b.authors) > 1")
    List<Book> findAllWithAuthorHasManyBooks();

    Long countByGenre(Genre genre);
}
