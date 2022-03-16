package com.fullstack.employee.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reviewerID ;
    private String asin ;
    private String reviewerName ;
    private String helpful ;
    @Lob
    private String reviewText ;
    private String overall ;
    private String summary ;
    private String unixReviewTime ;
    private String reviewTime ;

}
