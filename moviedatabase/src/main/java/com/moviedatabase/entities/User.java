package com.moviedatabase.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    // @Size(max = 20)
    private String name;

    @NotNull
    // @Size(min = 8,max = 20)
    private String password;

    @NotNull
    @Email
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Review> reviews;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public User(long id, @NotNull @Size(max = 20) String name, @NotNull @Size(min = 8, max = 20) String password,
            @NotNull @Email String email, Set<Review> reviews) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.reviews = reviews;
    }

    public User() {
    }

    
}
