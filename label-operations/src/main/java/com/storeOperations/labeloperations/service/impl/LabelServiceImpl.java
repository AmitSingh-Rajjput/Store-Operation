package com.storeOperations.labeloperations.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperations.labeloperations.entity.ChangeRequest;
import com.storeOperations.labeloperations.entity.ItemLabel;
import com.storeOperations.labeloperations.entity.LabelDto;
import com.storeOperations.labeloperations.entity.Replenishment;
import com.storeOperations.labeloperations.entity.ReplenishmentDto;
import com.storeOperations.labeloperations.entity.SelfLabel;
import com.storeOperations.labeloperations.exception.UserExceptionHandler;
import com.storeOperations.labeloperations.repository.ChangeRequestRepository;
import com.storeOperations.labeloperations.repository.ItemLabelRepository;
import com.storeOperations.labeloperations.repository.ReplenishmentRepository;
import com.storeOperations.labeloperations.repository.SelfLabelRepository;
import com.storeOperations.labeloperations.service.Labelservice;

@Service
public class LabelServiceImpl implements Labelservice {
	
	@Autowired
	private ItemLabelRepository itemLabelrepo;
	
	@Autowired
	private SelfLabelRepository selfLabelrepo;
	
	@Autowired
	private ReplenishmentRepository replenishmentRepo;
	
	@Autowired
	private ChangeRequestRepository changeRepo;

	@Override
	public String addLabelandProduct(LabelDto labeldto) {
		SelfLabel selfLabel = new SelfLabel();
		selfLabel.setSelfLabelId(labeldto.getSelfLabel().getSelfLabelId());
		selfLabel.setSelfLabelName(labeldto.getSelfLabel().getSelfLabelName());
		selfLabel.setSelfLabelImg(labeldto.getSelfLabel().getSelfLabelImg());
		selfLabel.setStoreName(labeldto.getSelfLabel().getStoreName());
		selfLabel.setMaxItem(labeldto.getSelfLabel().getMaxItem());
		selfLabel.setMaxQtyForSingleProduct(labeldto.getSelfLabel().getMaxQtyForSingleProduct());
		
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

	@Override
	public String replenishmentOrder(ReplenishmentDto replenishment) {
		
		SelfLabel label = selfLabelrepo.findBySelfLabelIdAndStoreName(replenishment.getSelfLabel(), replenishment.getStoreName());
		if(label == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Label id found!!");
		}
		
		for(int i =0;i<replenishment.getListItem().size();i++) {
			if(itemLabelrepo.findByItemCode(replenishment.getListItem().get(i).getItemCode()).getSelfLabel().getSelfLabelId() == null || itemLabelrepo.findByItemCode(replenishment.getListItem().get(i).getItemCode()).getSelfLabel().getSelfLabelId() != 
					label.getSelfLabelId()) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Items code is not aligned with this shelf");
			}
		}
		

		for(int i =0;i<replenishment.getListItem().size();i++) {
			
			replenishmentRepo.save(new Replenishment(replenishment.getListItem().get(i).getItemCode(),replenishment.getListItem().get(i).getCurrentQty(),label.getMaxQtyForSingleProduct(),replenishment.getListItem().get(i).getQtyReplenished(),
					replenishment.getListItem().get(i).getDate(),label));
			
		}
		
		
		return "Notification sent for replenishment!";
		
		
	}

	@Override
	public List<SelfLabel> selfLabel(String storeName) {
		List<SelfLabel> listLabel = selfLabelrepo.findByStoreName(storeName);
		if(listLabel.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No shelf found!");
		}
		
		return listLabel;
	}

	@Override
	public String addChangeRequest(ChangeRequest changeReq) {
		changeRepo.save(changeReq);
		return "Add change Label request sucessfully!";
	}

	@Override
	public List<ChangeRequest> allChangeRequest(String storeName) {
		List<ChangeRequest> allRequest = changeRepo.findByStoreName(storeName);
		if(allRequest.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Request found!");
		}
		
		return allRequest;
	}
	
	
	
	

}
