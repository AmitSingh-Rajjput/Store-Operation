package com.storeOperation.userregistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.storeOperation.userregistration.entity.LoginDto;
import com.storeOperation.userregistration.entity.RegisterDto;
import com.storeOperation.userregistration.entity.Store;
import com.storeOperation.userregistration.entity.User;

public interface AuthService {
	String login(LoginDto loginDto);
	
	String register(RegisterDto registerDto);
	
	Store storeGetById(Long id);
	
    List<Store> getAllStores();

	Store createStore(Store store);
	
	String deleteStore(Long Id);
	
	Store updateStore(Store store,Long storeId);
	
	Optional<User>  userDetails(String name);
    
    
}
