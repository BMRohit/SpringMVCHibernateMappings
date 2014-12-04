/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CategoryDAO;
import com.example.model.Category;

/**
 * @author Rohit
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	CategoryDAO dao;

	@Override
	public void insertCategory(Category category) {
		dao.insertCategory(category);
	}

	@Override
	public Category getCategory(long catID) {
		return dao.getCategory(catID);
	}

	@Override
	public void updateCategory(Category category) {
		dao.updateCategory(category);
	}

	@Override
	public void deleteCategory(long catID) {
		dao.deleteCategory(catID);
	}

	@Override
	public List<Category> getAllCategories() {
		return dao.getAllCategories();
	}

}
