package com.storeOperations.labeloperations.service;

import java.util.List;

import com.storeOperations.labeloperations.entity.ChangeRequest;
import com.storeOperations.labeloperations.entity.LabelDto;
import com.storeOperations.labeloperations.entity.PriceChangeLabel;
import com.storeOperations.labeloperations.entity.ReplenishmentDto;
import com.storeOperations.labeloperations.entity.SearchLabelDto;
import com.storeOperations.labeloperations.entity.SelfLabel;

public interface Labelservice {
	
	String addLabelandProduct(LabelDto labeldto);
	
	LabelDto viewItemInSelf(String selfLabelId,String storeName);
	
	String replenishmentOrder(ReplenishmentDto replenishment);
	
	List<SelfLabel> selfLabel(String storeName);
	
	String addChangeRequest(ChangeRequest changeReq);
	
	List<ChangeRequest> allChangeRequest(String storeName);
	
	SearchLabelDto lableInfo(String id,String storeName);
	
	List<PriceChangeLabel> detailLabel(String date,String storeName);
}
