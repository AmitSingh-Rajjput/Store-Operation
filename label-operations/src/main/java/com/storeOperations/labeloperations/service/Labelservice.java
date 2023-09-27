package com.storeOperations.labeloperations.service;

import com.storeOperations.labeloperations.entity.LabelDto;

public interface Labelservice {
	
	String addLabelandProduct(LabelDto labeldto);
	
	LabelDto viewItemInSelf(String selfLabelId,String storeName);

}
