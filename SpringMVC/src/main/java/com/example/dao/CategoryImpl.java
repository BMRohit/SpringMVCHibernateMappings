/**
 * 
 */
package com.example.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Category;
import com.example.model.Product;

/**
 * @author Rohit
 *
 */

@Repository
public class CategoryImpl implements CategoryDAO {

	private static final Logger logger = Logger.getLogger(ProductDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		if (sessionFactory != null) {
			return sessionFactory.getCurrentSession();
		} else
			throw new RuntimeException("Session Factory is null");
	}

	@Override
	public void insertCategory(Category category) {
		try{
			getCurrentSession().save(category);
			logger.info("Category "+ category + "inserted to database ");
		}
		catch(Exception e){
			logger.error(" error while saving product "+category,e);
		}
	}

	@Override
	public Category getCategory(long catID) {
		Category category = null;
		try{
			category =  (Category)getCurrentSession().get(Category.class, catID);
			logger.info("Product fetched from database ");
		}
		catch(Exception e){
			logger.error(" error while getting category of id "+catID,e);
		}
		return category;
	}

	@Override
	public void updateCategory(Category category) {

	}

	@Override
	public void deleteCategory(long catID) {
		try{
			getCurrentSession().delete(getCategory(catID));
			logger.info("Category deleted from from database ");
		}
		catch(Exception e){
			logger.error(" error while deleting Category of id "+catID,e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = null;
		try{
			categories = getCurrentSession().createQuery("from Category ").list();
			//To avoid lazy loading exception.
			for(Category category : categories)
			{
				category.getProductsList().size();
			}
			logger.info("Fetching all categories from database ");
		}
		catch(Exception e){
			logger.error(" error while getting list of categories",e);
		}
		return categories;
	}

}
