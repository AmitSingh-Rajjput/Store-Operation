package com.storeOperation.productinfomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;
import com.storeOperation.productinfomation.Entity.ProductDisplayPromotion;
import com.storeOperation.productinfomation.Entity.PromotionAddDto;
import com.storeOperation.productinfomation.Entity.PromotionDetailInfo;
import com.storeOperation.productinfomation.Entity.PromotionList;
import com.storeOperation.productinfomation.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> createProduct(@RequestBody Product prod){
		Product savedCheckList = productService.addProduct(prod);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addProductDetails/{productId}")
	public ResponseEntity<ProductDetails> createProductDetails(@PathVariable("productId")Long productId,@RequestBody ProductDetails prod){
		ProductDetails savedCheckList = productService.addProductDetails(productId,prod);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getProductDetailsInfo/{sku}/{storeName}")
	public ResponseEntity<ProductDisplayInfoDto> getProductDetailsInfo(@PathVariable("sku")String sku,@PathVariable("storeName") String storeName){
		ProductDisplayInfoDto savedData = productService.getAllDataBySkuandStore(sku,storeName);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	
	@GetMapping("/getProductStockinStores/{sku}")
	public ResponseEntity<List<ProductDetails>> getProductStockinStores(@PathVariable("sku")String sku){
		List<ProductDetails> savedData = productService.getAllStoreStockBySku(sku);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	@GetMapping("/getsimilarProduct/{category}")
	public ResponseEntity<List<Product>> getSimilarProductByCategory(@PathVariable("category")String cat){
		List<Product> savedData = productService.getAllSimilarProduct(cat);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	
	@PostMapping("/addPromotion")
	public ResponseEntity<String> addPromotions(@RequestBody PromotionList promoList){
		String savedCheckList = productService.addPromotion(promoList);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addPromotiontoItem")
	public ResponseEntity<String> addPromotionsToItem(@RequestBody List<PromotionAddDto> promotionItem){
		String savedCheckList = productService.addPromotionItemList(promotionItem);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/promoList")
	public ResponseEntity<List<PromotionList>> promoList(){
		List<PromotionList> promoList = productService.listAllPromotions();
		return new ResponseEntity<>(promoList,HttpStatus.CREATED);
	}
	
	@GetMapping("/promoListDetail/{promoId}")
	public ResponseEntity<PromotionDetailInfo> promoDetail(@PathVariable("promoId") String promoId){
		PromotionDetailInfo promoList = productService.promoDetail(promoId);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/promoItemDetail/{sku}")
	public ResponseEntity<ProductDisplayPromotion> promoItemDetail(@PathVariable("sku") String sku){
		ProductDisplayPromotion promoList = productService.promoDetailsOnProduct(sku);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}

}
