package com.storeOperations.storeappointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.storeappointments.entity.Appointment;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findByStoreNameAndDate(String storeName,String date);

}
