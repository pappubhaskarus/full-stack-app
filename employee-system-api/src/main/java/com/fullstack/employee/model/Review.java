package com.fullstack.employee.model;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@ToString
@Data
public class Review {
    private String reviewerID ;
    private String asin ;
    private String reviewerName ;
    private Set<Integer> helpful ;
    private String reviewText ;
    private String overall ;
    private String summary ;
    private String unixReviewTime ;
    private String reviewTime ;
}
