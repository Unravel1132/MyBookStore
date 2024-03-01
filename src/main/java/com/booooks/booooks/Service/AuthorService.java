package com.booooks.booooks.Service;

import com.booooks.booooks.Entity.AuthorEntity;
import com.booooks.booooks.Entity.BookEntity;
import com.booooks.booooks.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorEntity addAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<AuthorEntity> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public AuthorEntity updateAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }
    public List<BookEntity> findBooksByAuthorName(String authorName) {
        AuthorEntity author = authorRepository.findByName(authorName);
        if (author != null) {
            return author.getBooks();
        } else {
            return Collections.emptyList();
        }
    }

}
