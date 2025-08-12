package com.app.ecom.DTO;

import com.app.ecom.Model.UserRole;

import lombok.Data;
@Data
public class UserRequest {
	private String firstname;
	private String Lastname;
	private String Email;
	private String phone;

	private AddressDto address;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserRequest [firstname=" + firstname + ", Lastname=" + Lastname + ", Email=" + Email + ", phone="
				+ phone + ", address=" + address + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + ", getAddress()="
				+ getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public UserRequest(String firstname, String lastname, String email, String phone, AddressDto address) {
		super();
		this.firstname = firstname;
		Lastname = lastname;
		Email = email;
		this.phone = phone;
		this.address = address;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
