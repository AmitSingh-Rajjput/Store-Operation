package com.storeOperation.userregistration.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.storeOperation.userregistration.entity.LoginDto;
import com.storeOperation.userregistration.entity.RegisterDto;
import com.storeOperation.userregistration.entity.Store;

public interface AuthService {
	String login(LoginDto loginDto);
	
	String register(RegisterDto registerDto);
	
	Store storeGetById(Long id);
	
    List<Store> getAllStores();

	Store createStore(Store store);
	
	String deleteStore(Long Id);
	
	Store updateStore(Store store,Long storeId);
    
    
}
