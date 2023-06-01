package com.moviedatabase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviedatabase.entities.Movie;
import com.moviedatabase.repositories.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(long id){
        return movieRepository.findById(id).orElse(null);
    }

    public Movie getMovieByName(String name){
        return movieRepository.findByName(name);
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void addMovies(List<Movie> movie){
        movieRepository.saveAll(movie);
    }

    public void updateMovie(Movie movie,long id){
        Movie existingmovie = movieRepository.findById(id).orElse(null);
        if(existingmovie != null){
            existingmovie.setTitle(movie.getTitle());
            existingmovie.setGenre(movie.getGenre());
            existingmovie.setReleaseDate(movie.getReleaseDate());
            existingmovie.setDirector(movie.getDirector());
            existingmovie.setActors(movie.getActors());
            movieRepository.save(movie);
        }
    }

    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }
}
