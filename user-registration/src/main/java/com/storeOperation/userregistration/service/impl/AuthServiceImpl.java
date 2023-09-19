package com.storeOperation.userregistration.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.storeOperation.userregistration.entity.LoginDto;
import com.storeOperation.userregistration.entity.RegisterDto;
import com.storeOperation.userregistration.entity.Role;
import com.storeOperation.userregistration.entity.Store;
import com.storeOperation.userregistration.entity.User;
import com.storeOperation.userregistration.exception.UserExceptionHandler;
import com.storeOperation.userregistration.repository.RoleRepository;
import com.storeOperation.userregistration.repository.StoreRepository;
import com.storeOperation.userregistration.repository.UserRepository;
import com.storeOperation.userregistration.security.JwtTokenProvider;
import com.storeOperation.userregistration.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }


	@Override
	public String register(RegisterDto registerDto) {
		// TODO Auto-generated method stub
		if(userRepository.existsByUsername(registerDto.getUsername())) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Username already exist!");
		}
		
		if(userRepository.existsByEmail(registerDto.getEmail())) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Email already exist!");
		}
		
		 Store store = storeRepository.findByStoreName(registerDto.getstoreRef()) ;
		
		
		User user = new User();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setLocation(registerDto.getLocation());
		user.setAddress(registerDto.getAddress());
		user.setEmail(registerDto.getEmail());
		user.setPhoneNumber(registerDto.getPhoneNumber());
		user.setGender(registerDto.getGender());
		user.setStore(store);
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName("ROLE_USER").get();
		roles.add(userRole);
		user.setRoles(roles);
		
		userRepository.save(user);
		
		return "User registered successfully!";
	}
	
	public Store storeGetById(Long Id){
		Store store = storeRepository.findById(Id).orElseThrow(() -> new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Store id is not found!"));
		return store;
	}
	
	public List<Store> getAllStores() {
		// TODO Auto-generated method stub
		List<Store> stores = storeRepository.findAll();
		return stores;
		
	}


	@Override
	public Store createStore(Store store) {		
		Store storeName = storeRepository.findByStoreName(store.getStoreName());				
				if(storeName != null) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Store is already exist!");
		    }			
				Store savedStore = storeRepository.save(store);
				return savedStore;
	}
	
	public String deleteStore(Long Id) {
		Store store  = storeRepository.findById(Id).orElseThrow(
				()->  new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Store is not exist!"));
		storeRepository.deleteById(Id);
		return "Store deleted Sucessfully";
	}


	@Override
	public Store updateStore(Store store, Long storeId) {
		
				Store existingStore = storeRepository.findById(storeId).orElseThrow(
						() -> new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Store is not exist!"));
				existingStore.setStoreLocation(store.getStoreLocation());
				existingStore.setStoreName(store.getStoreName());
				Store updateStore = storeRepository.save(existingStore);
				return updateStore;
	}


	@Override
	public Optional<User> userDetails(String name) {
		Optional<User> user = userRepository.findByUsername(name);
		if(user == null) {
			new UserExceptionHandler(HttpStatus.BAD_REQUEST, "User not exist!");
		}
		return user;
	}
}


