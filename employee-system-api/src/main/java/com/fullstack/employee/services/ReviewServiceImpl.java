package com.fullstack.employee.services;


import com.fullstack.employee.entity.ReviewEntity;
import com.fullstack.employee.model.Review;
import com.fullstack.employee.repository.ReviewRepository;
import com.fullstack.employee.utils.Timed;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity();
        BeanUtils.copyProperties(review, reviewEntity);

        return mapReviewEntityToPOJO(reviewRepository.save(reviewEntity));
    }

    @Override
    public List<Review> getReviews() {
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewEntities.stream().map(this::mapReviewEntityToPOJO).collect(Collectors.toList());
    }


    @Override
    public void deleteReviews(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review getReviewsById(long id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).orElseThrow();
        return mapReviewEntityToPOJO(reviewEntity);
    }

    @Timed
    @Override
    public List<Review> findByReviewerID(String reviewerID) {
        List<ReviewEntity> reviewEntities = reviewRepository.findAllByReviewerID(reviewerID);
        return reviewEntities.stream().map(this::mapReviewEntityToPOJO).collect(Collectors.toList());
    }

    private Review mapReviewEntityToPOJO(ReviewEntity reviewEntity) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewEntity, review);
        return review;
    }

    @Override
    public long count() {
        return reviewRepository.count();
    }

    @Override
    public List<Review> findByReviewTextLike(String reviewText) {
        return reviewRepository.findByReviewTextLike(reviewText).stream().map(this::mapReviewEntityToPOJO).collect(Collectors.toList());
    }
}
