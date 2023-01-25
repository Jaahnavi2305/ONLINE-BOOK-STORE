package com.bootapp.rest.restapp.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Review;
import com.bootapp.rest.restapp.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	/* Review POST API */
	@PostMapping("/add")
	public ResponseEntity<String> postReview(@RequestBody Review review) {
		reviewService.insertReview(review);
		return ResponseEntity.status(HttpStatus.OK).body("Review posted in DB");
	}

	/* Get All API */
	@GetMapping("/getall")
	public List<Review> getAllReviews() {
		List<Review> list = reviewService.getAllReviews();
		return list;
	}

	/* Review PUT API */
	@PutMapping("/update/{reviewId}")
	public ResponseEntity<String> updateReviewById(@PathVariable("reviewId") int reviewId, @RequestBody Review review)
	{
	reviewService.updateReviewById(review);
    return ResponseEntity.status(HttpStatus.OK).body("Review is updated....");
	}
	
	/* Review DELETE API*/
	@DeleteMapping("/delete/{reviewId}")
	 public ResponseEntity<String> deleteReviewById(@RequestBody Review review){
	reviewService.deleteReviewById(review);
	return ResponseEntity.status(HttpStatus.OK).body("Review is deleted....");
	}

}

