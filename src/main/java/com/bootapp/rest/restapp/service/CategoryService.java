package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CategoryRepository;

import com.bootapp.rest.restapp.model.Category;
import com.bootapp.rest.restapp.model.Customer;
import com.rest.restapp.Exception.CategoryAlreadyExistsException;
import com.rest.restapp.Exception.CategoryNotFoundException;
import com.rest.restapp.Exception.NullValueException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

//	public void insertBook(Category category) {
//		categoryRepository.save(category);
//
//	}

//	public void insertBook(Category category) throws NullValueException, CategoryAlreadyExistsException {
//		List<Category> c1 = categoryRepository.findAll();
//		for (Category c : c1) {
//			if (c.getCategoryName().equalsIgnoreCase(category.getCategoryName())) {
//				throw new CategoryAlreadyExistsException("Category already exists");
//			}
//		}
//		String s1 = category.getCategoryName();
//		if (s1 == "") {
//			throw new NullValueException("Enter a category name first");
//		} else {
//			categoryRepository.save(category);
//		}
//	}
	public void insertCategory(Category category) throws NullValueException{
		String s1 = category.getName();
		if (s1 == "") {
			throw new NullValueException("Enter a category name first");
		} else {
			categoryRepository.save(category);
		}
	}


	public List<Category> getAllCategories() {

		return categoryRepository.findAll();
	}

//	public void updatecategoryById(Category category) {
//		categoryRepository.save(category);
//		
//	}

	public Category deleteCategoryById(int categoryId) throws CategoryNotFoundException {
		Optional<Category> cat = categoryRepository.findById(categoryId);
		if (cat.isPresent()) {

			categoryRepository.delete(cat.get());
			return cat.get();
		} else {
			throw new CategoryNotFoundException("category not found");
		}
	}

//	public Category getCategoryById(int cid) {
//		Optional<Category> optional = categoryRepository.findById(cid);
//		if(optional !=null)
//		return optional.get();
//		return null;
//	}

	public Optional<Category> getCategoryById(int id) {
		
		 return categoryRepository.findById(id);
				 }

	public void PostCategory(Category categoryDB) {
		categoryRepository.save(categoryDB);
	}

}