package com.Demo.LibraryApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.LibraryApp.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
