/**
 * 
 */
package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name = "BrandInfo")
public class BrandInfo {

	@Id
	@GeneratedValue
	private long brandID;
	private String brandName;
	private long contactNumber;
	private String email;

	public long getBrandID() {
		return brandID;
	}

	public void setBrandID(long brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BrandInfo [brandID=" + brandID + ", brandName=" + brandName
				+ ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}

}
