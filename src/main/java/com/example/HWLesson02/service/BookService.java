package com.example.HWLesson02.service;

import com.example.HWLesson02.dto.BookWithAuthorName;
import com.example.HWLesson02.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public List<BookWithAuthorName> getAllBooks() {
        try {
            return bookRepository.getAllBooks();
        } catch (Exception e) {
            System.out.println("Failed to get repo");
            return null;
        }
    }

    public @ResponseBody
    boolean addBook(@RequestParam String nameInput, @RequestParam String authorInput) {
        try {
            if (bookRepository.checkAuthorExist(authorInput) && !bookRepository.checkBookNameExist(nameInput)) {
                return bookRepository.addBook(nameInput, authorInput);
            } else if (!bookRepository.checkAuthorExist(authorInput)) {
                System.out.println("Author not existed");
                return false;
            } else if (bookRepository.checkBookNameExist(nameInput)) {
                System.out.println("Book existed");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Fail");
        }
        return true;
    }

    public boolean updateBook(String oldName, String nameInput) {
        try {
            if (bookRepository.checkOldBookNameExist(oldName)) {
                if (bookRepository.checkBookNameExist(nameInput)) {
                    return bookRepository.updateBook(oldName, nameInput);
                } else {
                    System.out.println("Duplicated");
                    return false;
                }
            } else {
                System.out.println("Book not found");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Fail");
        }
        return false;
    }

    public boolean deleteBook(String nameInput) {
        try {
            if (bookRepository.checkBookNameExist(nameInput)) {
                return bookRepository.deleteBook(nameInput);
            } else {
                System.out.println("Book not found");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Fail");
        }
        return false;
    }
}
