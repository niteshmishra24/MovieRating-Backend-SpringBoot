package com.moviedatabase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviedatabase.entities.Review;
import com.moviedatabase.services.ReviewService;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;

    @PostMapping("reviews/{userId}/user/{movieId}/movie")
    public void createReview(@RequestBody Review review,@PathVariable long userId,@PathVariable long movieId){
        reviewService.createReview(review, userId, movieId);
    }

    @DeleteMapping("reviews/{id}")
    public void deleteReview(@PathVariable long id){
        reviewService.deleteReview(id);
    }
}
