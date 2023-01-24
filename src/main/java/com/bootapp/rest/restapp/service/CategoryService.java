package com.bootapp.rest.restapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CategoryRepository;

import com.bootapp.rest.restapp.model.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void insertBook(Category category) {
		categoryRepository.save(category);
		
	}

	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
	}

	public void updatecategoryById(Category category) {
		categoryRepository.save(category);
		
	}

	public void deleteCategoryById(Category category) {
		categoryRepository.delete(category);
		
	}
	
	

}
