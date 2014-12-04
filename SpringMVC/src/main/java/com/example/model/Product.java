/**
 * 
 */
package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	private long productID;
	private String productName;
	private double price;
	/**
	 * The annotation @JoinColumn indicates that this entity is the owner of the
	 * relationship (that is: the corresponding table has a column with a
	 * foreign key to the referenced table), whereas the attribute @mappedBy
	 * indicates that the entity in this side is the inverse of the
	 * relationship, and the owner resides in the "other" entity.
	 */
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "BrandInfoID")
	private BrandInfo brandInfo;

	@ManyToMany(mappedBy="distributorProducts",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Distributor> distributors;

	public BrandInfo getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(BrandInfo brandInfo) {
		this.brandInfo = brandInfo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
	}

	public Product(long productID, String productName, double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIdAsString() {
		return new Long(productID).toString();
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName="
				+ productName + ", price=" + price + "]";
	}
}
