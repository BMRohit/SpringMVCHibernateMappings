/**
 * 
 */
package com.example.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name = "Distributor")
public class Distributor {
	
	
	@Id
	@GeneratedValue
	private long distributorID;
	private String distributorName;
	private String distributorNumber;
	private String distributorEmail;
	
	@ManyToMany
	@JoinTable(name = "Distributor_Prodcuts", joinColumns = { @JoinColumn(name = "Distributor_ID") }, inverseJoinColumns = { @JoinColumn(name = "Product_ID") })
	private Set<Product> distributorProducts;

	public long getDistributorID() {
		return distributorID;
	}


	public void setDistributorID(long distributorID) {
		this.distributorID = distributorID;
	}


	public String getDistributorName() {
		return distributorName;
	}


	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}


	public String getDistributorNumber() {
		return distributorNumber;
	}


	public void setDistributorNumber(String distributorNumber) {
		this.distributorNumber = distributorNumber;
	}


	public String getDistributorEmail() {
		return distributorEmail;
	}


	public void setDistributorEmail(String distributorEmail) {
		this.distributorEmail = distributorEmail;
	}


	public Set<Product> getDistributorProducts() {
		return distributorProducts;
	}


	public void setDistributorProducts(Set<Product> distributorProducts) {
		this.distributorProducts = distributorProducts;
	}


	
}
