/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.model.Distributor;
import com.example.model.Product;

/**
 * @author Rohit
 *
 */
public interface ProductService
{
	
	void insertProduct(Product product);
	Product getProduct(long productID);
	void updateProduct(Product product);
	void deleteProduct(long productID);
	List<Product> getProducts();
	void insertDistributor(Distributor distributor);
	

}
