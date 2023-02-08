package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.ReviewRepository;
import com.bootapp.rest.restapp.exception.NullValueException;
import com.bootapp.rest.restapp.model.Review;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	// public void updateReviewById(Review review) {
	// reviewRepository.save(review);
	// }

	public void insertBook(Review review) throws NullValueException {

		String s1 = review.getBookName();
		if (s1 == "") {
			throw new NullValueException("Enter a bookname first");
		} else {
			reviewRepository.save(review);
		}
	}

	public Review deleteReviewById(int id) {
		Optional<Review> optional = reviewRepository.findById(id);
		reviewRepository.delete(optional.get());
		return optional.get();
	}

	public Optional<Review> getReviewById(int id) {
		// TODO Auto-generated method stub
		Optional<Review> optional = reviewRepository.findById(id);
		return optional;
	}
	
	public List<Review> getAllReview() {
		List<Review> list = reviewRepository.findAll();
		return list;
		}

	public void PostReview(Review reviewDB) {
		// TODO Auto-generated method stub
		reviewRepository.save(reviewDB);

	}

	
}