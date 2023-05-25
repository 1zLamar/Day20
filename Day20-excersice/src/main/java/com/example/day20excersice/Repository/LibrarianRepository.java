package com.example.day20excersice.Repository;

import com.example.day20excersice.Model.Book;
import com.example.day20excersice.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByUsernameAndPassword(String username,String password);

    Librarian findLibrarianByEmail(String email);
}
