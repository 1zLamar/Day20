package com.example.day20excersice.Service;

import com.example.day20excersice.ApiException.ApiException;
import com.example.day20excersice.Model.Book;
import com.example.day20excersice.Model.Librarian;
import com.example.day20excersice.Repository.BookRepository;
import com.example.day20excersice.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarian(){
        List<Librarian> librarianList=librarianRepository.findAll();
        return librarianList;
    }

    public void addLibrarian(Librarian librarian){

        librarianRepository.save(librarian);
    }
    public void updateLibrarian(Librarian librarian , Integer id){
        Librarian librarian1=librarianRepository.findLibrarianById(id);
        if(librarian1==null){
            throw new ApiException("not found");
        }
        librarian1.setEmail(librarian.getEmail());
        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());

        librarianRepository.save(librarian1);
    }

    public void deleteLibrarian(Integer id){
        Librarian librarian=librarianRepository.findLibrarianById(id);
        if(librarian==null){
            throw new ApiException("not found");
        }
        librarianRepository.delete(librarian);
    }

    public Librarian findBlogById(Integer id){
        Librarian librarian=librarianRepository.findLibrarianById(id);
        if(librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }

    public Librarian getLibrarianByUsernameAndPassword(String username,String password){
        Librarian librarian=librarianRepository.findLibrarianByUsernameAndPassword(username,password);
        if(librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }

    public Librarian getLibrarianByEmail(String email){
        Librarian librarian=librarianRepository.findLibrarianByEmail(email);
        if(librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }



}
