package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.dto.Message;
import com.bootapp.rest.restapp.exception.NullValueException;
import com.bootapp.rest.restapp.model.Review;
import com.bootapp.rest.restapp.service.ReviewService;

@RestController
@CrossOrigin(origins = { "*" })

@RequestMapping("/api/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	/* Review POST API */

	@PostMapping("/add")
	public ResponseEntity<Message> insertReview(@RequestBody Review review) throws NullValueException {
		Message m = new Message();
		try {
			reviewService.insertReview(review);
			m.setMsg("Review added");
			return ResponseEntity.status(HttpStatus.OK).body(m);
		} catch (Exception e) {
			m.setMsg("Could not process the request, Try Again");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
		}
	}

	/* Get All API */
	@GetMapping("/getall")
	public List<Review> getAllReviews() {
		List<Review> list = reviewService.getAllReview();
		return list;
	}

	/* Review PUT API */

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editReview(@PathVariable("id") int id, @RequestBody Review reviewNew) {
		/* Step 1: check if this id given is valid by fetching the record from DB */
		Optional<Review> optional = reviewService.getReviewById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");

		}
		Review reviewDB = optional.get();
		/* Step 2: Set New value to DB value */
		if (reviewNew.getComments() != null)
			reviewDB.setComments(reviewNew.getComments());
		if (reviewNew.getRating() != 0)
			reviewDB.setRating(reviewNew.getRating());
		if (reviewNew.getBookName() != null)
			reviewDB.setBookName(reviewNew.getBookName());

		reviewService.PostReview(reviewDB);
		return ResponseEntity.status(HttpStatus.OK).body("review record Edited..");
	}

	/* Review DELETE API */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteReviewById(@PathVariable("id") int id) {
		Optional<Review> optional = reviewService.getReviewById(id);
		if (!optional.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
		reviewService.deleteReviewById(id);
		return ResponseEntity.status(HttpStatus.OK).body("review is deleted");
	}

}