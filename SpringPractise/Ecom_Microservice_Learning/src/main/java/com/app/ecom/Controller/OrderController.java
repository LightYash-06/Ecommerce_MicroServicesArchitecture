package com.app.ecom.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.DTO.OrderResponse;
import com.app.ecom.Services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
    private final OrderService orderService;
	
    

    public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}


	public OrderService getOrderService() {
		return orderService;
	}


	@PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestHeader("X-User-ID") String userId) {
        return orderService.createOrder(userId)
                .map(orderResponse -> new ResponseEntity<>(orderResponse, HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
