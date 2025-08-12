package com.app.ecom.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.DTO.ProductRequest;
import com.app.ecom.DTO.ProductResponse;
import com.app.ecom.Services.ProductService;
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private final ProductService productservice;
	
	
	
	 public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}



	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
	    ProductResponse response = productservice.createProduct(productRequest);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> updateProduct(
	    @PathVariable Long id,
	    @RequestBody ProductRequest productRequest) {
        return productservice.updateProduct(id, productRequest)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
                                    @PathVariable String id) {
        return productservice.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productservice.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam String keyword) {
        return ResponseEntity.ok(productservice.searchProducts(keyword));
    }


}
