package com.app.ecom.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.app.ecom.Model.OrderStatus;

public class OrderResponse {
    private Long id;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public List<OrderItemDTO> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "OrderResponse [id=" + id + ", totalAmount=" + totalAmount + ", status=" + status + ", items=" + items
				+ ", createdAt=" + createdAt + ", getId()=" + getId() + ", getTotalAmount()=" + getTotalAmount()
				+ ", getStatus()=" + getStatus() + ", getItems()=" + getItems() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public OrderResponse(Long id, BigDecimal totalAmount, OrderStatus status, List<OrderItemDTO> items,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.status = status;
		this.items = items;
		this.createdAt = createdAt;
	}
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
