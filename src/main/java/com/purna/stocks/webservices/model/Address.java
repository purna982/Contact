package com.purna.stocks.webservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, max=255, message="address label should have atleast 2 to 255 characters")
	@ApiModelProperty(notes="address label should have atleast 2 to 255 characters")
	@NotNull
	private String label;
	
	@Size(min=2, max=255,message="address should have atleast 2 to 255 characters")
	@ApiModelProperty(notes="address should have atleast 2 to 255 characters")
	private String address;
	
	public Address() {
		
	}

	public Address(Integer id, String label,
			@Size(min = 10, message = "address should have atleast 10 characters") String address) {
		super();
		this.id = id;
		this.label = label;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", label=" + label + ", address=" + address + "]";
	}
	
	
	
}
