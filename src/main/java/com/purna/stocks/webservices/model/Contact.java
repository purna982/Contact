package com.purna.stocks.webservices.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User contact information.")
@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, max=255, message="Name should have atleast 2 to 255 characters")
	@ApiModelProperty(notes="Name should have atleast 255 characters")
	@NotNull
	private String name;
	
	@Size(min=2, max=255,message="Organasation should have atleast 2 to 255 characters")
	@ApiModelProperty(notes="Organasation should have atleast 2 to 255 characters")
	@NotNull
	private String organasation;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
	private PhoneNumber phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
	private Address address;
	
	public Contact() {
		
	}

	public Contact(Integer id, @Size(min = 10, message = "Name should have atleast 10 characters") String name,
			@Size(min = 16, message = "Name should have atleast 16 characters") String organasation,
			PhoneNumber phoneNumber, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.organasation = organasation;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganasation() {
		return organasation;
	}

	public void setOrganasation(String organasation) {
		this.organasation = organasation;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", organasation=" + organasation + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}

	
	
	

}
