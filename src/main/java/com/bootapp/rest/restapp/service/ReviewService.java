package com.bootapp.rest.restapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.ReviewRepository;
import com.bootapp.rest.restapp.model.Review;

@Service
public class ReviewService {
	
    @Autowired
    private ReviewRepository reviewRepository;
    
	public void insertReview(Review review) {
		reviewRepository.save(review);
	}

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public void updateReviewById(Review review) {
			reviewRepository.save(review);
			}

	public void deleteReviewById(Review review) {
		reviewRepository.delete(review);
	}
		
	}


