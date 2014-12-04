/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.model.Category;

/**
 * @author Rohit
 *
 */
public interface CategoryService 
{
	
	void insertCategory(Category category);
	Category getCategory(long catID);
	void updateCategory(Category category);
	void deleteCategory(long catID);
	List<Category> getAllCategories();

}
