package com.sombra.library.dao;

import com.sombra.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Anastasiya Vasylykiv
 */
public interface AuthorDao extends JpaRepository<Author, Integer> {

    @Query(value = "select * from Author where date_sub(now(), INTERVAL born YEAR) >= :age ORDER BY born", nativeQuery = true)
    List<Author> findAllByGreaterAge(@Param("age") Integer age);

    @Query("select a from Author a group by a.id having max(size(a.books)) = size(a.books)")
    Author findAuthorWithMostBooks();
}
