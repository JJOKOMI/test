package org.example.springboottest.springbootdeveloper.repository;

import org.example.springboottest.springbootdeveloper.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
