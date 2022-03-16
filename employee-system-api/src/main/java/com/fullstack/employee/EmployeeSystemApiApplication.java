package com.fullstack.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstack.employee.model.Review;
import com.fullstack.employee.repository.ReviewRepository;
import com.fullstack.employee.services.ReviewService;
import com.fullstack.employee.services.ReviewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class EmployeeSystemApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSystemApiApplication.class, args);
    }


    @Autowired
    ReviewService reviewService;


    @Override
    public void run(String... args) throws Exception {
//        reviewLoader("CDs_and_Vinyl_5.json");
//        reviewLoader("Musical_Instruments_5.json");

        log.info("{}", reviewService.count());

        List<Review> reviewList = reviewService.findByReviewerID("A3EVGPGOFVAP09");
        log.info("{}", reviewList);


    }

    private void reviewLoader(String file) {
        String fileName = "C:\\Users\\YO\\Downloads\\"+file;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(s -> {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Review review = mapper.readValue((s), Review.class);
                    reviewService.createReview(review);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                log.info("{}", s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


