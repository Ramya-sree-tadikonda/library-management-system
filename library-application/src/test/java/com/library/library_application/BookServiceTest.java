package com.library.library_application;

import com.library.library_application.model.Book;
import com.library.library_application.repository.BookRepository;
import com.library.library_application.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        book.setTitle("Java Basics");
        book.setAuthor("Ramya");
        book.setAvailableStatus(true);

        // Mock the repository save
        when(bookRepository.save(book)).thenReturn(book);

        // Call the service
        Book savedBook = bookService.addBook(book);

        // Assert
        assertNotNull(savedBook);  // This will now pass
        assertEquals("Java Basics", savedBook.getTitle());
    }

    @Test
    void testGetBookById() {
        Book book = new Book();
        book.setBookId(1);
        book.setTitle("Java Basics");

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(1);
        assertTrue(foundBook.isPresent());
        assertEquals("Java Basics", foundBook.get().getTitle());
    }
}
