package com.example.day20excersice.Controller;

import com.example.day20excersice.Model.Book;
import com.example.day20excersice.Model.Librarian;
import com.example.day20excersice.Service.BookService;
import com.example.day20excersice.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAllLibrarians(){
        List<Librarian> librarian=librarianService.getAllLibrarian();
        return ResponseEntity.status(200).body(librarian);
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@Valid@RequestBody Librarian librarian,@PathVariable Integer id){
        librarianService.updateLibrarian(librarian,id);
        return ResponseEntity.status(200).body("Librarian updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Librarian librarian=librarianService.findBlogById(id);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity getLibrarianByUsernameAndPassword(@PathVariable String username , @PathVariable String password){
        Librarian librarian=librarianService.getLibrarianByUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email){
        Librarian librarian=librarianService.getLibrarianByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }


}
