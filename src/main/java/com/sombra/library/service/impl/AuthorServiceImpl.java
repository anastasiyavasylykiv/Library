package com.sombra.library.service.impl;

import com.sombra.library.dao.AuthorDao;
import com.sombra.library.entity.Author;
import com.sombra.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiya Vasylykiv
 */
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public Author saveAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorDao.findById(id);
    }

    @Override
    public void removeAuthorById(Integer id) {
        authorDao.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public List<Author> findAllAgeGreaterThan(Integer age) {
        return authorDao.findAllByGreaterAge(age);
    }
}
