package com.booooks.booooks.Service;

import com.booooks.booooks.Entity.BookEntity;
import com.booooks.booooks.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> findAllBook() {
        return bookRepository.findAll();
    }

    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);


    }

    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);

    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
