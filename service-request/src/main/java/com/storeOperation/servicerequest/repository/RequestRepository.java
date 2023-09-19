package com.storeOperation.servicerequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.servicerequest.entity.Request;

public interface RequestRepository extends JpaRepository<Request,Long> {

	Request findByRequestId(String id);

}
