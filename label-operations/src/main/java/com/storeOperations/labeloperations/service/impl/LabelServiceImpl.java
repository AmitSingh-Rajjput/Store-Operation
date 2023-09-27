package com.storeOperations.labeloperations.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperations.labeloperations.entity.ItemLabel;
import com.storeOperations.labeloperations.entity.LabelDto;
import com.storeOperations.labeloperations.entity.SelfLabel;
import com.storeOperations.labeloperations.exception.UserExceptionHandler;
import com.storeOperations.labeloperations.repository.ItemLabelRepository;
import com.storeOperations.labeloperations.repository.SelfLabelRepository;
import com.storeOperations.labeloperations.service.Labelservice;

@Service
public class LabelServiceImpl implements Labelservice {
	
	@Autowired
	private ItemLabelRepository itemLabelrepo;
	
	@Autowired
	private SelfLabelRepository selfLabelrepo;

	@Override
	public String addLabelandProduct(LabelDto labeldto) {
		SelfLabel selfLabel = new SelfLabel();
		selfLabel.setSelfLabelId(labeldto.getSelfLabel().getSelfLabelId());
		selfLabel.setSelfLabelName(labeldto.getSelfLabel().getSelfLabelName());
		selfLabel.setSelfLabelImg(labeldto.getSelfLabel().getSelfLabelImg());
		selfLabel.setStoreName(labeldto.getSelfLabel().getStoreName());
		selfLabel.setMaxItem(labeldto.getSelfLabel().getMaxItem());
		
		selfLabelrepo.save(selfLabel);
		
		if(labeldto.getSelfLabel().getMaxItem() < labeldto.getItemList().size()) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Max item range exceed!!");
		}
		
		for(int i=0;i< labeldto.getItemList().size();i++) {
			itemLabelrepo.save(new ItemLabel(labeldto.getItemList().get(i).getItemLabelName(),labeldto.getItemList().get(i).getItemCode(),labeldto.getItemList().get(i).getItemLabelImg(),selfLabel ));
		}
		
		return "Add Item into label sucessfully!!";
	}

	@Override
	public LabelDto viewItemInSelf(String selfLabelId, String storeName) {
		
		SelfLabel label = selfLabelrepo.findBySelfLabelIdAndStoreName(selfLabelId, storeName);
		
		if(label == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Label id found!!");
		}
		
		List<ItemLabel> itemList = itemLabelrepo.findBySelfLabel(label);
		LabelDto detailLabel = new LabelDto();
		detailLabel.setSelfLabel(label);
		detailLabel.setItemList(itemList);
		
		return detailLabel;
			
		
	}
	
	
	
	

}
