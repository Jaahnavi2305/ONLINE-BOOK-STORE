package com.bootapp.rest.restapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bootapp.rest.restapp.enums.CategoryEnum;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Enumerated(EnumType.STRING)
		private CategoryEnum categoryenum;
		
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public CategoryEnum getCategoryenum() {
			return categoryenum;
		}

		public void setCategoryenum(CategoryEnum categoryenum) {
			this.categoryenum = categoryenum;
		}

		
}

