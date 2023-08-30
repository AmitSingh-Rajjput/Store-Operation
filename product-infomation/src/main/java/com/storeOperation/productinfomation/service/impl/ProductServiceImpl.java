package com.storeOperation.productinfomation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.productinfomation.exception.UserExceptionHandler;
import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;
import com.storeOperation.productinfomation.repository.ProductDetailsRepository;
import com.storeOperation.productinfomation.repository.ProductRepository;
import com.storeOperation.productinfomation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductDetailsRepository productDetailsRepo;
	

	@Override
	public Product addProduct(Product product) {
		
		Product previous = productRepo.findByProductSku(product.getProductSku());
		if(previous != null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product Id is already added");
		}
		
		return productRepo.save(product);
		
	}

	@Override
	public ProductDetails addProductDetails(Long prodId, ProductDetails prodDetails) {
		
		Product prod = productRepo.findById(prodId).get();
		
		if(prod == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product Id is not found!!");
	    }				
		ProductDetails details = new ProductDetails();
		details.setSize(prodDetails.getSize());
		details.setColor(prodDetails.getColor());
		details.setStockCount(prodDetails.getStockCount());
		details.setTypeOfStock(prodDetails.getTypeOfStock());
		details.setStore(prodDetails.getStore());
		details.setProduct(prod);
		return productDetailsRepo.save(details);
	}

	@Override
	public ProductDisplayInfoDto getAllDataBySkuandStore(String sku,String storeName) {
		Product previous = productRepo.findByProductSku(sku);
		if(previous == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product is not found");
		}
		
		ProductDisplayInfoDto display = new ProductDisplayInfoDto();
		
		List<ProductDetails> prodDdetails = productDetailsRepo.findByproductAndStore(previous,storeName);
		
		display.setProduct(previous);
		display.setProductDetails(prodDdetails);
		return display;
	}

	@Override
	public List<ProductDetails> getAllStoreStockBySku(String sku) {
		
		Product previous = productRepo.findByProductSku(sku);
		if(previous == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product is not found");
		}
		List<ProductDetails> prodDdetails = productDetailsRepo.findByproduct(previous);
		
		
		return prodDdetails;
	}

	@Override
	public List<Product> getAllSimilarProduct(String category) {
		List<Product> similarCategory = productRepo.findByProductType(category);
		
		if(similarCategory.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Not similar product found");
		}
		
		return similarCategory;
	}

}
