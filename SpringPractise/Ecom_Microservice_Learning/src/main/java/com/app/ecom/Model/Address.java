package com.app.ecom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	private String country;
	private String state;
	private String city;
	private String street;
	private String zipcode;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [Id=" + Id + ", country=" + country + ", state=" + state + ", city=" + city + ", street="
				+ street + ", zipcode=" + zipcode + ", getId()=" + getId() + ", getCountry()=" + getCountry()
				+ ", getState()=" + getState() + ", getCity()=" + getCity() + ", getStreet()=" + getStreet()
				+ ", getZipcode()=" + getZipcode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Long id, String country, String state, String city, String street, String zipcode) {
		super();
		Id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
  
}
