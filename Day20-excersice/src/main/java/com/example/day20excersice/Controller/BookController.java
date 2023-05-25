package com.example.day20excersice.Controller;

import com.example.day20excersice.Model.Book;
import com.example.day20excersice.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAllBooks(){
        List<Book> bookList=bookService.getAllBooks();
        return ResponseEntity.status(200).body(bookList);
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
         bookService.addBook(book);
         return ResponseEntity.status(200).body("book added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid@RequestBody Book book,@PathVariable Integer id){
        bookService.updateBook(book,id);
        return ResponseEntity.status(200).body("book updated");
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("book deleted");
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getBookByCategory(@PathVariable String category){
        List<Book> bookList=bookService.getBookByCategory(category);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/get-pages/{numberOfPages}")
    public ResponseEntity getBookByNumberOfPages(@PathVariable Integer numberOfPages){
        List<Book> bookList=bookService.getBookByNumberOfPages(numberOfPages);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/get-author/{author}")
    public ResponseEntity getBookByAuthor(@PathVariable String author){
        List<Book> bookList=bookService.getBookByAuthor(author);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        Book book=bookService.getBookByTitle(title);
        return ResponseEntity.status(200).body(book);
    }
}
