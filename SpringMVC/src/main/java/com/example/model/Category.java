/**
 * 
 */
package com.example.model;

import java.util.List;

import com.example.model.Product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue
	private long categoryID;

	private String categoryName;
	private String categoryDescription;

	/**
	 * The annotation @JoinColumn indicates that this entity is the owner of the
	 * relationship (that is: the corresponding table has a column with a
	 * foreign key to the referenced table), whereas the attribute @mappedBy
	 * indicates that the entity in this side is the inverse of the
	 * relationship, and the owner resides in the "other" entity.
	 * mappedBy = "category" is an entity present in Product class.
	 */
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Product> productsList;

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName="
				+ categoryName + ", categoryDescription=" + categoryDescription
				+ "]";
	}

	public String getIdAsString() {
		return new Long(categoryID).toString();
	}

}
