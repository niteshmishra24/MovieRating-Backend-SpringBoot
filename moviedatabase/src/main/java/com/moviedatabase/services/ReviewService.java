package com.moviedatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviedatabase.entities.Movie;
import com.moviedatabase.entities.Review;
import com.moviedatabase.entities.User;
import com.moviedatabase.repositories.MovieRepository;
import com.moviedatabase.repositories.ReviewRepository;
import com.moviedatabase.repositories.UserRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired 
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public void createReview(Review review,long user_id,long movie_id){
        Movie movie = movieRepository.findById(movie_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        if(movie != null && user != null){
            review.setUser(user);
            review.setMovie(movie);
            user.getReviews().add(review);
            movie.getReviews().add(review);
            reviewRepository.save(review);
        }
    }

    public void deleteReview(long id){
        reviewRepository.deleteById(id);
    }
}
