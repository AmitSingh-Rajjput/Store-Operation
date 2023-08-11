package com.storeOperation.userregistration.controller;

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

import com.storeOperation.userregistration.entity.Store;
import com.storeOperation.userregistration.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class StoreController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/createStore")
	public ResponseEntity<Store> createUser(@RequestBody Store store){
		Store savedStore = authService.createStore(store);
		return new ResponseEntity<>(savedStore,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public Store postDemo(@PathVariable("id") Long id){
		
		return authService.storeGetById(id);
		
		
	}
	
	@GetMapping("/getAllStores")
	public ResponseEntity<List<Store>> getAllStores(){
		
		List<Store> stores = authService.getAllStores();
		
		return new ResponseEntity<>(stores,HttpStatus.OK);
		
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteStore(@PathVariable("id") Long id){
		return new ResponseEntity<>(authService.deleteStore(id),HttpStatus.OK);
		
	}
	
	@PostMapping("/updateStore/{id}")
	public ResponseEntity<Store> upadteStore(@RequestBody Store store, @PathVariable("id") Long id){
		return new ResponseEntity<>(authService.updateStore(store,id),HttpStatus.OK);
	}
	
	
	

}
