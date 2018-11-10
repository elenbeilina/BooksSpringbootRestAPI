package com.belch.Books_spring.controller;

import com.belch.Books_spring.exception.ResourceNotFoundException;
import com.belch.Books_spring.model.Book;
import com.belch.Books_spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/bookmanager")
    public Page<Book> getBooks(Pageable pageable)
    {
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/bookmanager")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/bookmanager/{bookId}")
    public Book updateQuestion(@PathVariable Integer bookId,
                                   @Valid @RequestBody Book bookRequest) {
        return bookRepository.findById(bookId)
                .map(book -> {
                    book.setTitle(bookRequest.getTitle());
                    book.setAuthor(bookRequest.getAuthor());
                    return bookRepository.save(book);
                }).orElseThrow(() -> new ResourceNotFoundException("Book with this id is not found " + bookId));
    }

    @DeleteMapping("/bookmanager/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        return bookRepository.findById(bookId)
                .map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Book with this id is not found" + bookId));
    }
}
