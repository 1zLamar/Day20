package com.example.day20excersice.Repository;

import com.example.day20excersice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);

    List<Book> findBookByCategory(String category);

    List<Book> findBookByNumberOfPages(int numberOfPages);

    List<Book> findBookByAuthor(String author);

    Book findBookByTitle(String title);

}
