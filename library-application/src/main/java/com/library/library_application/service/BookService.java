package com.library.library_application.service;

import com.library.library_application.model.Book;
import com.library.library_application.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
