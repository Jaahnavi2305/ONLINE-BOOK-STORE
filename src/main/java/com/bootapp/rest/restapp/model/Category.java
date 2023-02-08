package com.bootapp.rest.restapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bootapp.rest.restapp.enums.CategoryEnum;

@Entity
@Table (name = "Catgeory") 
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	
		@Column(name = "CategoryEnum")
		@Enumerated(EnumType.STRING)
		private CategoryEnum categoryenum;


		public int getCategoryId() {
			return categoryId;
		}


		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}


		public CategoryEnum getCategoryenum() {
			return categoryenum;
		}


		public void setCategoryenum(CategoryEnum categoryenum) {
			this.categoryenum = categoryenum;
		}
		
		
		
		
		
}

