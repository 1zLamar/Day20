package com.example.day20excersice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;

    @NotEmpty(message = "Author shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String author;

    @NotEmpty(message = "category shouldn't be empty")
    @Column(columnDefinition = "varchar(25) not null check(category='academic' or category='mystery' or category='novel')")
    private String category;

    @NotNull(message = "ISBN shouldn't be null")
    @Column(columnDefinition = "int(10) not null")
    private Integer ISBN;

    @NotNull(message = "Number of pages shouldn't be null")
    @Min(50)
    @Column(columnDefinition = "int(4) not null")
    private Integer numberOfPages;



}
