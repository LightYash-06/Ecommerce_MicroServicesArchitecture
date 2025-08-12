package com.app.ecom.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.app.ecom.DTO.ProductRequest;
import com.app.ecom.DTO.ProductResponse;
import com.app.ecom.Model.Product;
import com.app.ecom.Repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository ;
	
	

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}



	public ProductResponse createProduct(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		Product product = new Product();
		updateProductFromRequest(product , productRequest);
	Product savedProduct =	productRepository.save(product);
		return mapToProductResponse(savedProduct);
	}



	private ProductResponse mapToProductResponse(Product savedProduct) {
	    ProductResponse response = new ProductResponse();
	    response.setId(savedProduct.getId());
	    response.setName(savedProduct.getName());
	    response.setActive(savedProduct.isActive());
	    response.setCategory(savedProduct.getCategory());
	    response.setDescription(savedProduct.getDescription());
	    response.setPrice(savedProduct.getPrice());
	    response.setImageUrl(savedProduct.getImageUrl());
	    response.setStockQuantity(savedProduct.getStockQuantity());
	    return response;
	}



	private void updateProductFromRequest(Product product, ProductRequest productRequest) {
	    product.setName(productRequest.getName());
	    product.setCategory(productRequest.getCategory());
	    product.setDescription(productRequest.getDescription());
	    product.setPrice(productRequest.getPrice());
	    product.setImageUrl(productRequest.getImageUrl());
	    product.setStockQuantity(productRequest.getStockQuantity());
	}



    public Optional<ProductResponse> updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    updateProductFromRequest(existingProduct, productRequest);
                    Product savedProduct = productRepository.save(existingProduct);
                    return mapToProductResponse(savedProduct);
                });
    }
    
    public List<ProductResponse> getAllProducts() {
        return productRepository.findByActiveTrue().stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }
    
    public boolean deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setActive(false);
                    productRepository.save(product);
                    return true;
                }).orElse(false);
    }
    
    
    public List<ProductResponse> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword).stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponse> getProductById(String id) {
        return productRepository.findByIdAndActiveTrue(Long.valueOf(id))
                .map(this::mapToProductResponse);
    }

}
