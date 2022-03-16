package com.fullstack.employee.controller;

import com.fullstack.employee.model.Employee;
import com.fullstack.employee.model.Review;
import com.fullstack.employee.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getEmployees(@RequestParam("reviewText") String reviewText) {
        return ResponseEntity.ok(reviewService.findByReviewTextLike(reviewText));
    }
}
