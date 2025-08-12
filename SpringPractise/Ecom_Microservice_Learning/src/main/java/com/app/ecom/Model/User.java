package com.app.ecom.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*import lombok.Data;*/

/*@Data*/

@Entity(name="UserTable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long ID;
	private String firstname;
	private String Lastname;
	private String Email;
	private String phone;
	private UserRole role = UserRole.CUSTOMER;
	
	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "address_id", referencedColumnName = "Id")
	private Address address;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public User(long iD, String firstname, String lastname, String email, String phone, UserRole role, Address address,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		ID = iD;
		this.firstname = firstname;
		Lastname = lastname;
		Email = email;
		this.phone = phone;
		this.role = role;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User(long iD, String firstname, String lastname, String email, String phone, UserRole role) {
		super();
		ID = iD;
		this.firstname = firstname;
		Lastname = lastname;
		Email = email;
		this.phone = phone;
		this.role = role;
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
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
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
	@Override
	public String toString() {
		return "User [ID=" + ID + ", firstname=" + firstname + ", Lastname=" + Lastname + ", Email=" + Email
				+ ", phone=" + phone + ", role=" + role + ", address=" + address + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", getAddress()=" + getAddress() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone()
				+ ", getRole()=" + getRole() + ", getID()=" + getID() + ", getFirstname()=" + getFirstname()
				+ ", getLastname()=" + getLastname() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public User(long iD, String firstname, String lastname) {
		super();
		ID = iD;
		this.firstname = firstname;
		Lastname = lastname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
