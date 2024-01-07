package com.storeOperation.productinfomation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.productinfomation.exception.UserExceptionHandler;
import com.storeOperation.productinfomation.Entity.ModePaymentDto;
import com.storeOperation.productinfomation.Entity.OrderDto;
import com.storeOperation.productinfomation.Entity.OrderItems;
import com.storeOperation.productinfomation.Entity.OrderTable;
import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;
import com.storeOperation.productinfomation.Entity.ProductDisplayPromotion;
import com.storeOperation.productinfomation.Entity.PromotionAddDto;
import com.storeOperation.productinfomation.Entity.PromotionDetailInfo;
import com.storeOperation.productinfomation.Entity.PromotionItemList;
import com.storeOperation.productinfomation.Entity.PromotionList;
import com.storeOperation.productinfomation.Entity.SalesReportDto;
import com.storeOperation.productinfomation.Entity.StoreSalesDto;
import com.storeOperation.productinfomation.repository.OrderItemsRepository;
import com.storeOperation.productinfomation.repository.OrderRepository;
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
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemsRepository orderItemRepo;
	

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

	@Override
	public List<Product> getAllMatchProduct(String sku) {
		
		return productRepo.findByProductSkuContainingIgnoreCase(sku);
	}

	@Override
	public String addOrdersPlaced(OrderDto orderInfo) {
		
		orderRepo.save(orderInfo.getOrder());

		for(int i=0;i<orderInfo.getNoOfProducts();i++) {
			
			if(productRepo.findByProductSku(orderInfo.getProductId().get(i))!= null) {
				
				Product prod = productRepo.findByProductSku(orderInfo.getProductId().get(i));
				
				OrderTable orderId = orderRepo.findById(orderInfo.getOrder().getId()).get();
				
				orderItemRepo.save(new OrderItems(prod,orderId,orderInfo.getQuantity().get(i),orderInfo.getListPrice().get(i),orderInfo.getDiscount().get(i)));
				
				return "Order Added successfully!";
			}
			else {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Product is not found!");
			}
		}
		
		return null;
	}

	@Override
	public StoreSalesDto salesDetailsYear(String storename,String year) {
		
		List<OrderTable> orders = orderRepo.findByYearAndStoreName(year, storename);
		
		StoreSalesDto sales = new StoreSalesDto();
		
		float grossSale = 0;
		float netSales = 0;
		float discount = 0;
		float returnSales = 0;
		
		
		
		for(int i=0;i<orders.size();i++) {
			
			netSales += orders.get(i).getTotalBill();
			
			List<OrderItems> orderDetails = orderItemRepo.findByOrder(orders.get(i));
			
			for(int j=0;j<orderDetails.size();j++) {
				
				grossSale += orderDetails.get(j).getListPrice();
				discount += orderDetails.get(j).getDiscount();
			}
			
		}
		
		List<OrderTable> returnOrder = orderRepo.findByOrderStatusAndStoreNameAndYear("Return", storename,year);
		
		for(int i =0;i<returnOrder.size();i++) {
			returnSales += returnOrder.get(i).getTotalBill();
		}
		
		sales.setDiscount(discount);
		sales.setGrossSales(grossSale);
		sales.setNetSales(netSales);
		sales.setReturnOrder(returnSales);
		return sales;
	}

	@Override
	public StoreSalesDto salesDetailsMonthAndYear(String storename, String month, String year) {
        
		List<OrderTable> orders = orderRepo.findByYearAndMonthAndStoreName(year,month,storename);
		
		StoreSalesDto sales = new StoreSalesDto();
		
		float grossSale = 0;
		float netSales = 0;
		float discount = 0;
		float returnSales = 0;
		
		
		
		for(int i=0;i<orders.size();i++) {
			
			netSales += orders.get(i).getTotalBill();
			
			List<OrderItems> orderDetails = orderItemRepo.findByOrder(orders.get(i));
			
			for(int j=0;j<orderDetails.size();j++) {
				
				grossSale += orderDetails.get(j).getListPrice();
				discount += orderDetails.get(j).getDiscount();
			}
			
			
		}
		
		List<OrderTable> returnOrder = orderRepo.findByOrderStatusAndStoreNameAndYearAndMonth("Return", storename,year,month);
		
		for(int k =0;k<returnOrder.size();k++) {
			returnSales += returnOrder.get(k).getTotalBill();
		}
		
		
		sales.setDiscount(discount);
		sales.setGrossSales(grossSale);
		sales.setNetSales(netSales);
		sales.setReturnOrder(returnSales);
		return sales;
	}

	@Override
	public StoreSalesDto salesDetailsDate(String storename, String date) {
        
		List<OrderTable> orders = orderRepo.findByDateAndStoreName(date,storename);
		
		StoreSalesDto sales = new StoreSalesDto();
		
		float grossSale = 0;
		float netSales = 0;
		float discount = 0;
		float returnSales = 0;
		
		
		
		for(int i=0;i<orders.size();i++) {
			
			netSales += orders.get(i).getTotalBill();
			
			List<OrderItems> orderDetails = orderItemRepo.findByOrder(orders.get(i));
			
			for(int j=0;j<orderDetails.size();j++) {
				
				grossSale += orderDetails.get(j).getListPrice();
				discount += orderDetails.get(j).getDiscount();
			}
			
			
		}
		
		List<OrderTable> returnOrder = orderRepo.findByOrderStatusAndStoreNameAndDate("Return", storename,date);
		
		for(int k =0;k<returnOrder.size();k++) {
			returnSales += returnOrder.get(k).getTotalBill();
		}
		
		
		sales.setDiscount(discount);
		sales.setGrossSales(grossSale);
		sales.setNetSales(netSales);
		sales.setReturnOrder(returnSales);
		return sales;
	}

	@Override
	public ModePaymentDto modeofSalesInYear(String storename, String year) {
		
		
		List<OrderTable> salesYearCash = orderRepo.findByPaymentModeAndStoreNameAndYear("Cash", storename, year);
		
		List<OrderTable> salesYearCheque = orderRepo.findByPaymentModeAndStoreNameAndYear("Cheque", storename, year);
		
		List<OrderTable> salesYearCreadit = orderRepo.findByPaymentModeAndStoreNameAndYear("Credit Card", storename, year);
		List<OrderTable> salesYearDebit = orderRepo.findByPaymentModeAndStoreNameAndYear("Debit Card", storename, year);
		
		List<OrderTable> salesYearGift = orderRepo.findByPaymentModeAndStoreNameAndYear("Gift Card", storename, year);
		
		ModePaymentDto modes = new ModePaymentDto();
		
		modes.setCash(salesYearCash.size());
		modes.setCheque(salesYearCheque.size());
		modes.setCreditcard(salesYearCreadit.size());
		modes.setDebitcard(salesYearDebit.size());
		modes.setGiftcard(salesYearGift.size());
		
		return modes;
	}

	@Override
	public ModePaymentDto modeofSalesInYearMonth(String storename, String year, String month) {
		
        List<OrderTable> salesYearCash = orderRepo.findByPaymentModeAndStoreNameAndYearAndMonth("Cash", storename, year,month);
		
		List<OrderTable> salesYearCheque = orderRepo.findByPaymentModeAndStoreNameAndYearAndMonth("Cheque", storename, year,month);
		
		List<OrderTable> salesYearCreadit = orderRepo.findByPaymentModeAndStoreNameAndYearAndMonth("Credit Card", storename, year,month);
		List<OrderTable> salesYearDebit = orderRepo.findByPaymentModeAndStoreNameAndYearAndMonth("Debit Card", storename, year,month);
		
		List<OrderTable> salesYearGift = orderRepo.findByPaymentModeAndStoreNameAndYearAndMonth("Gift Card", storename, year,month);
		
		ModePaymentDto modes = new ModePaymentDto();
		
		modes.setCash(salesYearCash.size());
		modes.setCheque(salesYearCheque.size());
		modes.setCreditcard(salesYearCreadit.size());
		modes.setDebitcard(salesYearDebit.size());
		modes.setGiftcard(salesYearGift.size());
		
		return modes;
	}

	@Override
	public ModePaymentDto modeinCurrentDate(String storename, String date) {
		
		 List<OrderTable> salesYearCash = orderRepo.findByPaymentModeAndStoreNameAndDate("Cash", storename,date);
			
			List<OrderTable> salesYearCheque = orderRepo.findByPaymentModeAndStoreNameAndDate("Cheque", storename,date);
			
			List<OrderTable> salesYearCreadit = orderRepo.findByPaymentModeAndStoreNameAndDate("Credit Card", storename,date);
			List<OrderTable> salesYearDebit = orderRepo.findByPaymentModeAndStoreNameAndDate("Debit Card", storename,date);
			
			List<OrderTable> salesYearGift = orderRepo.findByPaymentModeAndStoreNameAndDate("Gift Card", storename,date);
			
			ModePaymentDto modes = new ModePaymentDto();
			
			modes.setCash(salesYearCash.size());
			modes.setCheque(salesYearCheque.size());
			modes.setCreditcard(salesYearCreadit.size());
			modes.setDebitcard(salesYearDebit.size());
			modes.setGiftcard(salesYearGift.size());
			
			return modes;
		
	}

	@Override
	public List<SalesReportDto> reportMonthWise(String storename, String month,String year) {
		
		List<OrderTable> orders = orderRepo.findByYearAndMonthAndStoreName(month, year, storename);
		if(orders.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No order is found!!");
		}
		List<SalesReportDto> report = new ArrayList<>();
		for(int i=0;i<orders.size();i++) {
			List<OrderItems> items = orderItemRepo.findByOrder(orders.get(i));
			report.add(new SalesReportDto(orders.get(i),items));
		}
		return report;
	}

	@Override
	public List<SalesReportDto> reportDateWise(String storename, String date) {
		List<OrderTable> orders = orderRepo.findByDateAndStoreName(date, storename);
		if(orders.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No order is found!!");
		}
		List<SalesReportDto> report = new ArrayList<>();
		for(int i=0;i<orders.size();i++) {
			List<OrderItems> items = orderItemRepo.findByOrder(orders.get(i));
			report.add(new SalesReportDto(orders.get(i),items));
		}
		return report;
	}

	@Override
	public List<SalesReportDto> reportByStaffwise(String storename, String name) {
		List<OrderTable> orders = orderRepo.findByStaffNameAndStoreName(name, storename);
		if(orders.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No order is found!!");
		}
		List<SalesReportDto> report = new ArrayList<>();
		for(int i=0;i<orders.size();i++) {
			List<OrderItems> items = orderItemRepo.findByOrder(orders.get(i));
			report.add(new SalesReportDto(orders.get(i),items));
		}
		return report;
	}

	@Override
	public List<SalesReportDto> reportStaffMonthandYear(String storename, String name, String month, String year) {
		List<OrderTable> orders = orderRepo.findByStaffNameAndStoreNameAndMonthAndYear(name, storename,month,year);
		if(orders.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No order is found!!");
		}
		List<SalesReportDto> report = new ArrayList<>();
		for(int i=0;i<orders.size();i++) {
			List<OrderItems> items = orderItemRepo.findByOrder(orders.get(i));
			report.add(new SalesReportDto(orders.get(i),items));
		}
		return report;
	}

	@Override
	public List<SalesReportDto> reportSatffDatewise(String storename, String name, String date) {
		List<OrderTable> orders = orderRepo.findByStaffNameAndStoreNameAndDate(name, storename,date);
		if(orders.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No order is found!!");
		}
		List<SalesReportDto> report = new ArrayList<>();
		for(int i=0;i<orders.size();i++) {
			List<OrderItems> items = orderItemRepo.findByOrder(orders.get(i));
			report.add(new SalesReportDto(orders.get(i),items));
		}
		return report;
	}


}
