package com.app.ecom.DTO;

import java.math.BigDecimal;

public class OrderItemDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "OrderIteamDTO [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", price=" + price
				+ ", subTotal=" + subTotal + ", getId()=" + getId() + ", getProductId()=" + getProductId()
				+ ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + ", getSubTotal()=" + getSubTotal()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public OrderItemDTO(Long id, Long productId, Integer quantity, BigDecimal price, BigDecimal subTotal) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}
	public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
