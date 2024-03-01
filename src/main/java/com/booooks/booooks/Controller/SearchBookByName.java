package com.booooks.booooks.Controller;


import com.booooks.booooks.Entity.AuthorEntity;
import com.booooks.booooks.Entity.BookEntity;
import com.booooks.booooks.Service.AuthorService;
import com.booooks.booooks.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchBookByName {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public SearchBookByName(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/books/{authorName}")
    public List<BookEntity> getBooksByAuthorName(@PathVariable String authorName) {
        return authorService.findBooksByAuthorName(authorName);
    }

}
