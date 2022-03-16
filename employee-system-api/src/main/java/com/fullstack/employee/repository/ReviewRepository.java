package com.fullstack.employee.repository;

import com.fullstack.employee.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Transactional
    List<ReviewEntity> findAllByReviewerID(String reviewerID);

//    @Query("from Review where reviewText like %:reviewText%")
@Transactional
    List<ReviewEntity> findByReviewTextLike(String reviewText);
}