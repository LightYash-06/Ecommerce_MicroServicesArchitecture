package com.app.ecom.DTO;

public class CartItemRequest {
    private Long productId;
    private Integer quantity;
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
	@Override
	public String toString() {
		return "CartItemRequest [productId=" + productId + ", quantity=" + quantity + ", getProductId()="
				+ getProductId() + ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public CartItemRequest(Long productId, Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public CartItemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
