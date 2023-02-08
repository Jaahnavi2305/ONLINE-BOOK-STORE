package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

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

//    public void updatecategoryById(Category category) {
//        categoryRepository.save(category);
//        
//    }     
	public Category deleteCategoryById(int categoryId) {
	Optional<Category> optional = categoryRepository.findById(categoryId);
			categoryRepository.delete(optional.get());
			return optional.get();
			}

	public Optional<Category> getCategoryById(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional;
	}

//  public Optional<Category> getCategoryById1(int id) {
//        
//         return categoryRepository.findById(id);
//                 }     
	public void PostCategory(Category categoryDB) {
		categoryRepository.save(categoryDB);
	}
}