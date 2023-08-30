package com.storeOperation.productinfomation.service;

import java.util.List;

import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;

public interface ProductService {
	
	Product addProduct(Product product);
    ProductDetails addProductDetails(Long prodId,ProductDetails prodDetails);
    
    ProductDisplayInfoDto getAllDataBySkuandStore(String sku,String storeName);
    
    List<ProductDetails> getAllStoreStockBySku(String sku);
    
    List<Product> getAllSimilarProduct(String category);
}
