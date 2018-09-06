package com.sombra.library.controller;

import com.sombra.library.entity.Book;
import com.sombra.library.entity.Genre;
import com.sombra.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiya Vasylykiv
 */
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public List<Book> getAuthor(@PathVariable(value = "id", required = false) Integer id) {
        return id == null ? bookService.findAll() :
                bookService.findById(id).map(Collections::singletonList).orElseGet(Collections::emptyList);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping(value = "/books")
    public Book updateBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") Integer id) {
        Optional<Book> bookById = bookService.findById(id);
        bookService.removeBookById(id);
        return (ResponseEntity) (bookById.isPresent() ? ResponseEntity.ok() : ResponseEntity.badRequest());
    }

    @GetMapping(value = "/filteredBooks")
    public List<Book> getFilteredBooks(){
        return bookService.findAllWithAuthorHasManyBooks();
    }

    @GetMapping(value = "/genreBooks")
    public ResponseEntity<Long> countBooksByGenre(@RequestParam("genre")String genre){
        try {
            return ResponseEntity.ok(bookService.countByGenre(Genre.valueOf(genre)));
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
