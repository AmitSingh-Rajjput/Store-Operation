package com.storeOperations.storeappointments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.storeappointments.entity.Appointment;
import com.storeOperations.storeappointments.entity.Participants;

public interface ParticipantsRepository extends JpaRepository<Participants, Long> {

	List<Participants> findByAppointment(Appointment app);
}
