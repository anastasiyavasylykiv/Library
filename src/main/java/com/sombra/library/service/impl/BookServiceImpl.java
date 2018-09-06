package com.sombra.library.service.impl;

import com.sombra.library.dao.BookDao;
import com.sombra.library.entity.Book;
import com.sombra.library.entity.Genre;
import com.sombra.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiya Vasylykiv
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Override
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookDao.findById(id);
    }


    @Override
    public void removeBookById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findAllWithAuthorHasManyBooks() {
        return bookDao.findAllWithAuthorHasManyBooks();
    }

    @Override
    public Long countByGenre(Genre genre) {
        return bookDao.countByGenre(genre);
    }
}
