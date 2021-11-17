/**
 * 
 */
package com.jpms.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Administrator
 *
 */

@Entity
public class Address {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="doorNo")
	private String doorNo;
	@Column(name="street")
	private String street;
	@Column(name="pinCode")
	private Long pinCode;
	
	@OneToOne(mappedBy = "address")
    private Student student;
	
	public Address() {
		
	}
	
	/**
	 * @param doorNo
	 * @param street
	 * @param pinCode
	 */
	/* public Address(String doorNo, String street, Long pinCode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.pinCode = pinCode;
	}
	*/
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	/**
	 * @return the doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}
	

	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the pinCode
	 */
	public Long getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}	
	
}
