/**
 * 
 */
package com.jpms.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Administrator
 *
 */

@Entity
public class Student {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	// private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
	
	public Student() {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param address
	 */
	/* public Student(Integer id, String name, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		// this.address = address;
	}
	*/
	
	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	/* public Address getAddress() {
		return address;
	}
	*/
	/**
	 * @param address the address to set
	 */
	/* public void setAddress(Address address) {
		this.address = address;
	}
	*/
	
}
