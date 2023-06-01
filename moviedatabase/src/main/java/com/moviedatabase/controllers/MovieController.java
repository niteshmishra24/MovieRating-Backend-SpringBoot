package com.moviedatabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviedatabase.entities.Movie;
import com.moviedatabase.services.MovieService;

@RestController
@RequestMapping("/api/")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping("movies")
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();
    }

    @GetMapping("movies/{id}")
    public Movie getMovieById(@PathVariable long id){
        return movieService.getMovieById(id);
    }

    @GetMapping("movies/{name}")
    public Movie getMovieByName(@PathVariable String name){
        return movieService.getMovieByName(name);
    }
    
    @PostMapping("movies/addMovie")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }
    
    @PostMapping("movies/addMovies")
    public void addMovies(@RequestBody List<Movie> movie){
        movieService.addMovies(movie);
    }

    @PutMapping("movies/{id}")
    public void updateMovie(@PathVariable long id,@RequestBody Movie movie){
        movieService.updateMovie(movie, id);
    }

    @DeleteMapping("movies/{id}")
    public void deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
    }
}
