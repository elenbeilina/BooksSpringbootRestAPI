package com.belch.Books_spring.repository;

import com.belch.Books_spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
}
