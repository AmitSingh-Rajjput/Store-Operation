package com.storeOperation.productinfomation.service;

import java.util.List;

import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;
import com.storeOperation.productinfomation.Entity.ProductDisplayPromotion;
import com.storeOperation.productinfomation.Entity.PromotionAddDto;
import com.storeOperation.productinfomation.Entity.PromotionDetailInfo;
import com.storeOperation.productinfomation.Entity.PromotionList;

public interface ProductService {
	
	Product addProduct(Product product);
    ProductDetails addProductDetails(Long prodId,ProductDetails prodDetails);
    
    ProductDisplayInfoDto getAllDataBySkuandStore(String sku,String storeName);
    
    List<ProductDetails> getAllStoreStockBySku(String sku);
    
    List<Product> getAllSimilarProduct(String category);
    
    String addPromotion(PromotionList promoList);
    
    String addPromotionItemList(List<PromotionAddDto> promotionItem);
    
    List<PromotionList> listAllPromotions();
    
    PromotionDetailInfo promoDetail(String promoId);
    
    ProductDisplayPromotion promoDetailsOnProduct(String productSku);
}
