package com.example.day20excersice.Service;

import com.example.day20excersice.ApiException.ApiException;
import com.example.day20excersice.Model.Book;
import com.example.day20excersice.Repository.BookRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> bookList=bookRepository.findAll();
        return bookList;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void updateBook(Book book , Integer id){
        Book book1=bookRepository.findBookById(id);
        if(book1==null){
            throw new ApiException("not found");
        }
        book1.setTitle(book.getTitle());
        book1.setCategory(book.getCategory());
        book1.setAuthor(book.getAuthor());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages(book.getNumberOfPages());

        bookRepository.save(book1);
    }

    public void deleteBook(Integer id){
        Book book1=bookRepository.findBookById(id);
        if(book1==null){
            throw new ApiException("not found");
        }
        bookRepository.delete(book1);
    }

    public List getBookByCategory(String category){
        List<Book> bookList=bookRepository.findBookByCategory(category);
        if(bookList==null){
            throw new ApiException("not found");
        }
        return bookList;
    }

    public List getBookByNumberOfPages(int numberOfPages){
        List<Book> bookList=bookRepository.findBookByNumberOfPages(numberOfPages);
        if(bookList==null){
            throw new ApiException("not found");
        }
        return bookList;
    }

    public List getBookByAuthor(String author){
        List<Book> bookList=bookRepository.findBookByAuthor(author);
        if(bookList==null){
            throw new ApiException("not found");
        }
        return bookList;
    }

    public Book getBookByTitle(String title){
        Book book=bookRepository.findBookByTitle(title);
        if(book==null){
            throw new ApiException("not found");
        }
        return book;
    }





}
