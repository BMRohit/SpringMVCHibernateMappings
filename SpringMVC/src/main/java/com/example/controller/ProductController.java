/**
 * 
 */
package com.example.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Category;
import com.example.model.Distributor;
import com.example.model.Product;
import com.example.service.CategoryService;
import com.example.service.ProductService;

/**
 * @author Rohit
 *
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	private static final Logger logger = Logger
			.getLogger(ProductController.class);

	//Can use cache or can directly get from DB using ID
	private Map<String, Product> productCache;
	private Map<Long, Category> categoryCache;

	/**
	 * The ModelAndView can be constructed with 3 parameters. (View name , Model
	 * name , model object) By default model name "command" is used because the
	 * spring framework expects an object with name "command" if you are using
	 * <form:form> tags in your JSP file. Model name can be changed to any other
	 * name and same name should be used in JSP with command = "samplename".
	 * 
	 * @return
	 */

	@RequestMapping(value = "/productpage", method = RequestMethod.GET)
	private ModelAndView getAddProductPage() {
		ModelAndView modelAndView = new ModelAndView("add-product", "product",
				new Product());
		categoryCache = new HashMap<Long, Category>();
		List<Category> categories = categoryService.getAllCategories();
		if (categories != null && !categories.isEmpty()) {
			for (Category category : categories) {
				categoryCache.put(category.getCategoryID(),category);
			}
		}
		modelAndView.addObject("categoryList", categories);
		return modelAndView;
	}

	// Simple modelandview without redirection
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	private ModelAndView addingProduct(@ModelAttribute Product product) {
		logger.info("Product adding to database...");
		ModelAndView modelAndView = new ModelAndView("home");
		productService.insertProduct(product);
		modelAndView.addObject("message", "Product was successfully added.");
		return modelAndView;
	}

	@RequestMapping(value = "/listofproducts", method = RequestMethod.GET)
	private ModelAndView getListOfProducts() {
		logger.info("getting all the Product from database...");
		List<Product> products = new ArrayList<Product>();
		products = productService.getProducts();
		ModelAndView modelAndView = new ModelAndView("list-of-products");
		modelAndView.addObject("products", products);
		return modelAndView;
	}

	// Used the re-direction mechanism; After deleting the product it redirects
	// to home page.
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	private ModelAndView deleteProduct(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) {
		logger.info("Deleting product from database..." + id);
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		productService.deleteProduct(id);
		redirectAttributes.addFlashAttribute("message",
				"Product was successfully deleted.");
		return modelAndView;
	}

	@RequestMapping(value = "/geteditpage/{id}", method = RequestMethod.GET)
	private ModelAndView getEditProductPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-product-form");
		modelAndView.addObject("product", productService.getProduct(id));
		return modelAndView;
	}

	// Used the re-direction mechanism; After updating the product it redirects
	// to home page.
	@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
	private ModelAndView updateProduct(@ModelAttribute Product product,
			final RedirectAttributes redirectAttributes) {
		logger.info("Updating product to database...");
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		productService.updateProduct(product);
		redirectAttributes.addFlashAttribute("message",
				"Product was successfully updated.");
		return modelAndView;
	}

	@RequestMapping(value = "/distributorpage", method = RequestMethod.GET)
	private ModelAndView getAddDistributorPage() {
		ModelAndView modelAndView = new ModelAndView("add-distributor",
				"distributor", new Distributor());
		List<Product> products = productService.getProducts();
		Map<String,Product> productsMap = new HashMap<String, Product>();
		productCache = new HashMap<String, Product>();
		for (Product product : products) {
			productCache.put(product.getIdAsString(), product);
			productsMap.put(product.getProductName(), product);
		}
		modelAndView.addObject("products", products);
		return modelAndView;
	}

	// Simple modelandview without redirection
	@RequestMapping(value = "/addDistributor", method = RequestMethod.POST)
	private ModelAndView addingDistributor(@ModelAttribute Distributor distributor) {
		ModelAndView modelAndView = new ModelAndView("home");
		productService.insertDistributor(distributor);
		modelAndView.addObject("message", "Distributor was successfully added.");
		return modelAndView;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		//Binder for products [Distributor has set of products]
		binder.registerCustomEditor(Set.class, "distributorProducts",new CustomCollectionEditor(Set.class) {
					protected Object convertElement(Object element) {
						if (element instanceof Category) {
							return element;
						}
						if (element instanceof String) {
							//Can use cache or can directly get from DB using ID
							Product product = productCache.get(element);
							logger.info("Looking up for product of id "+ element + ": " + product);
							return product;
						}
						logger.debug("Spring couldn't bind object "+ element);
						return null;
					}
				});
		//Binder for categories [Prodcut has category]
		binder.registerCustomEditor(Category.class, "category",new PropertyEditorSupport() {
			    @Override
			    public void setAsText(String text) {
			    	//Can use cache or can directly get from DB using ID
			        Category category = categoryCache.get(Long.parseLong(text));
			        setValue(category);
			    }
			    });
	}
	
}
