package com.sombra.library.controller;

import com.sombra.library.entity.Author;
import com.sombra.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiya Vasylykiv
 */
@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public List<Author> getAuthor(@PathVariable(value = "id", required = false) Integer id) {
        return id == null ? authorService.findAll() :
                authorService.findById(id).map(Collections::singletonList).orElseGet(Collections::emptyList);
    }

    @PostMapping(value = "/authors")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping(value = "/authors")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping(value = "/authors/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") Integer id) {
        Optional<Author> authorById = authorService.findById(id);
        authorService.removeAuthorById(id);
        return (ResponseEntity) (authorById.isPresent() ? ResponseEntity.ok() : ResponseEntity.badRequest());
    }

    @RequestMapping(value = "/filteredAuthors", method = RequestMethod.GET)
    public List<Author> getFilteredAuthors(@RequestParam(value = "olderThan") Integer age){
        return authorService.findAllAgeGreaterThan(age);
    }
}
