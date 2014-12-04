/**
 * 
 */
package com.example.dao;

import java.util.List;

import com.example.model.Category;
import com.example.model.Product;

/**
 * @author Rohit
 *
 */
public interface CategoryDAO {
	
	void insertCategory(Category category);
	Category getCategory(long catID);
	void updateCategory(Category category);
	void deleteCategory(long catID);
	List<Category> getAllCategories();

}
