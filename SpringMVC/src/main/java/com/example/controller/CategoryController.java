/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Category;
import com.example.service.CategoryService;

/**
 * @author Rohit
 *
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	private static final Logger logger = Logger.getLogger(CategoryController.class);

	@RequestMapping(value = "/categorypage", method = RequestMethod.GET)
	private ModelAndView getAddProductPage() {
		return new ModelAndView("add-category", "category", new Category());
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	private ModelAndView addingCategory(@ModelAttribute Category category,final RedirectAttributes redirectAttributes) {
		logger.info("adding category to database...");
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		categoryService.insertCategory(category);
		redirectAttributes.addFlashAttribute("message", "Category was successfully added.");
		return modelAndView;
	}
	
	@RequestMapping(value = "/listcategories", method = RequestMethod.GET)
	private ModelAndView getCategories() {
		ModelAndView modelAndView = new ModelAndView("list-of-categories");
		List<Category> categories = categoryService.getAllCategories();
		modelAndView.addObject("categories",categories);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	private ModelAndView deleteCategory(@PathVariable Integer id,final RedirectAttributes redirectAttributes)
	{
		logger.info("Deleting category from database..."+id);
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		categoryService.deleteCategory(id);
		redirectAttributes.addFlashAttribute( "message","Category was successfully deleted.");
		return modelAndView;
	}

}
