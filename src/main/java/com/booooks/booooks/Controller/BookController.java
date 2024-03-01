package com.booooks.booooks.Controller;

import com.booooks.booooks.Entity.BookEntity;
import com.booooks.booooks.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/add-book")
    public String addBook() {
        return "add-book";
    }

    @PostMapping("/add-book")
    public String saveBook(@ModelAttribute BookEntity newBook, Model model) {
        // Сохраняем книгу
        bookService.saveBook(newBook);
        List<BookEntity> books = bookService.findAllBook();
        model.addAttribute("books", books);

        return "redirect:/genres"; // После сохранения перенаправляем обратно на страницу добавления книги
    }
}
