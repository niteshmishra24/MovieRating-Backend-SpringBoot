package com.moviedatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviedatabase.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(value = "SELECT * FROM Movie WHERE title = ?1", nativeQuery = true)
    Movie findByName(String name);
}
