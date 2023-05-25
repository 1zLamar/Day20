package com.example.day20excersice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name shouldn't be empty")
    private String name;

    @NotEmpty(message = "username shouldn't be empty")
    private String username;

    @NotEmpty(message = "password shouldn't be empty")
    @Pattern(regexp = "^[a-zA-Z]\\w{3,14}$")
    private String password;

    @NotEmpty(message = "Email shouldn't be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

}
