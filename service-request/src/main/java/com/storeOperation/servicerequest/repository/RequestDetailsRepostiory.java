package com.storeOperation.servicerequest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.servicerequest.entity.Request;
import com.storeOperation.servicerequest.entity.RequestDetails;

public interface RequestDetailsRepostiory extends JpaRepository<RequestDetails,Long >{

	List<RequestDetails> findByRequest(Request req);
}

