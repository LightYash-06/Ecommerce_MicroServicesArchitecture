package com.app.ecom.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "product_id")

private Long id;
private String name;
private String description;
private BigDecimal price;
private Integer stockQuantity;
private String category;
private String imageUrl;
private boolean active=true;
@CreationTimestamp
private LocalDateTime createdAt;
@UpdateTimestamp
private LocalDateTime updatedAt;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public Integer getStockQuantity() {
	return stockQuantity;
}
public void setStockQuantity(Integer stockQuantity) {
	this.stockQuantity = stockQuantity;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
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
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
			+ ", stockQuantity=" + stockQuantity + ", category=" + category + ", imageUrl=" + imageUrl + ", active="
			+ active + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", getId()=" + getId() + ", getName()="
			+ getName() + ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice()
			+ ", getStockQuantity()=" + getStockQuantity() + ", getCategory()=" + getCategory() + ", getImageUrl()="
			+ getImageUrl() + ", isActive()=" + isActive() + ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()="
			+ getUpdatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
public Product(Long id, String name, String description, BigDecimal price, Integer stockQuantity, String category,
		String imageUrl, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.stockQuantity = stockQuantity;
	this.category = category;
	this.imageUrl = imageUrl;
	this.active = active;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}


}
