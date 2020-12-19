package com.example.HWLesson02.controller;

import com.example.HWLesson02.dto.BookWithAuthorName;
import com.example.HWLesson02.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private static BookController instance;

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    private BookController() {

    }

    BookService bookService = new BookService();

    @GetMapping("/all-books")
    public List<BookWithAuthorName> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add-book")
    public @ResponseBody boolean addBook(@RequestParam String nameInput, @RequestParam String authorInput) {
        return bookService.addBook(nameInput, authorInput);
    }

    @PutMapping("/edit-book")
    public @ResponseBody boolean updateBook(@RequestParam String oldName, @RequestParam String nameInput) throws SQLException {
        return bookService.updateBook(oldName, nameInput);
    }

    @DeleteMapping("/delete-book")
    public @ResponseBody boolean deleteBook(@RequestParam String nameInput) {
        return bookService.deleteBook(nameInput);
    }

}
