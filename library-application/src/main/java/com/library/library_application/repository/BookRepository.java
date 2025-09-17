package com.library.library_application.repository;


import com.library.library_application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // No need to add anything, Spring will auto-generate the implementation
}

