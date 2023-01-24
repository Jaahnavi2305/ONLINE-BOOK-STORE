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

import com.bootapp.rest.restapp.model.Category;
import com.bootapp.rest.restapp.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;
	
	@PostMapping("/add")
	public ResponseEntity<String> postCategory(@RequestBody Category category) {
		categoryservice.insertBook(category);
		return ResponseEntity.status(HttpStatus.OK).body("Category posted in DB");
		
	}
	
	@GetMapping("/getall")
	public List<Category> getAllCategories() {
		List<Category> list = categoryservice.getAllCategories();
		return list;
	}
	
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<String> updateAuthorById(@PathVariable("categoryId") int authorId, @RequestBody Category category){
	categoryservice.updatecategoryById(category);
	return ResponseEntity.status(HttpStatus.OK).body("Category is update");
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<String> deleteCategoryById(@RequestBody Category category){
	categoryservice.deleteCategoryById(category);
	return ResponseEntity.status(HttpStatus.OK).body("category is deleted....");
	}
}

