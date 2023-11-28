package com.storeOperation.productinfomation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.productinfomation.exception.UserExceptionHandler;
import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;
import com.storeOperation.productinfomation.Entity.ProductDisplayPromotion;
import com.storeOperation.productinfomation.Entity.PromotionAddDto;
import com.storeOperation.productinfomation.Entity.PromotionDetailInfo;
import com.storeOperation.productinfomation.Entity.PromotionItemList;
import com.storeOperation.productinfomation.Entity.PromotionList;
import com.storeOperation.productinfomation.repository.ProductDetailsRepository;
import com.storeOperation.productinfomation.repository.ProductRepository;
import com.storeOperation.productinfomation.repository.PromotionItemListRepository;
import com.storeOperation.productinfomation.repository.PromotionListRepository;
import com.storeOperation.productinfomation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductDetailsRepository productDetailsRepo;
	
	@Autowired
	private PromotionListRepository promoListRepo;
	
	@Autowired
	private PromotionItemListRepository promoItemListRepo;
	

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

	@Override
	public String addPromotion(PromotionList promoList) {
		PromotionList newPromo = promoListRepo.findByPromotionId(promoList.getPromotionId());
		if(newPromo != null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Promotion already exist!");
		}
		PromotionList promo = promoListRepo.save(promoList);
		return "Add promotion sucessfully!";
	}

	@Override
	public String addPromotionItemList(List<PromotionAddDto> promotionItem) {
		for(int i=0;i< promotionItem.size();i++) {
			Product findProduct = productRepo.findByProductSku(promotionItem.get(i).getProductItemNo());
			if(findProduct == null) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product is not found!");
			}
			PromotionList promotion = promoListRepo.findByPromotionId(promotionItem.get(i).getPromotionId());
			if(promotion == null) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Promotion is not found!");
			}
			promoItemListRepo.save(new PromotionItemList(findProduct, promotion,promotionItem.get(i).getProductPromoPrice()));
		}
		
		return "Added promotion to item sucessfully!";
	}

	@Override
	public List<PromotionList> listAllPromotions() {
		
		List<PromotionList> listAllPromo = promoListRepo.findAll();
		if(listAllPromo.size()==0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Promotion list is empty");
		}
		return listAllPromo;
	}

	@Override
	public PromotionDetailInfo promoDetail(String promoId) {
		System.out.println("Promo Id"+ promoId);
		PromotionList promo = promoListRepo.findByPromotionId("ABS12");
		System.out.println(promo.getPromotionDescription());
		if(promo == null){
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Promotion is not found!");
		}
		
		List<PromotionItemList> promoList = promoItemListRepo.findByPromotionList(promo);
		System.out.println(promoList.size());
		
		PromotionDetailInfo detail = new PromotionDetailInfo();
		
		detail.setPromoDetails(promo);
		detail.setPromoItemList(promoList);
		return detail;
		
	}

	@Override
	public ProductDisplayPromotion promoDetailsOnProduct(String productSku) {
		
		Product prod = productRepo.findByProductSku(productSku);
		if(prod == null){
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product is not found!");
		}
		
		List<PromotionItemList> promoId = promoItemListRepo.findByProduct(prod);
		
		ProductDisplayPromotion display = new ProductDisplayPromotion();
		display.setProduct(prod);
		display.setPromoItemList(promoId);
		
		return display;
	}


}
