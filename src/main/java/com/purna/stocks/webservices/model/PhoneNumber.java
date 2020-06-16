package com.purna.stocks.webservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PhoneNumber {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, max=255, message="label should have atleast 2 to 255 characters")
	@ApiModelProperty(notes="label should have atleast 2 to 255 characters")
	@NotNull
	private String label;
	
	@Size(min=10, message="Number should have atleast 10 characters")
	@ApiModelProperty(notes="Number should have atleast 10 characters")
	@NotNull
	private String number;
	
	public PhoneNumber() {
		
	}

	public PhoneNumber(Integer id, String label,
			@Size(min = 10, message = "Number should have atleast 10 characters") String number) {
		super();
		this.id = id;
		this.label = label;
		this.number = number;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", label=" + label + ", number=" + number + "]";
	}
	
	

}
