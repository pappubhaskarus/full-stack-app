package com.fullstack.employee.services;

import com.fullstack.employee.model.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getReviews();

    void deleteReviews(long id);

    Review getReviewsById(long id);

    List<Review> findByReviewerID(String reviewerID);

    long count();

    List<Review> findByReviewTextLike(String reviewText);
}
