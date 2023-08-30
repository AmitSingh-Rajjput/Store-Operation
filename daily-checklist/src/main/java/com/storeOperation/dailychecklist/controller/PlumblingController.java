package com.storeOperation.dailychecklist.controller;

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

import com.storeOperation.dailychecklist.entity.PlumblingChecklist;
import com.storeOperation.dailychecklist.entity.TaskPlumblingChecklist;
import com.storeOperation.dailychecklist.service.PlumblingChecklistService;

@RestController
@RequestMapping("/api/dayChecklist")
public class PlumblingController {

	@Autowired
	private PlumblingChecklistService plumblingservice;
	
	@PostMapping("/addPlumbingChecklist")
	public ResponseEntity<String> createPlumblingChecklistType(@RequestBody PlumblingChecklist checklist){
		String savedCheckList = plumblingservice.createPlumblingChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPlumblingChecklist")
	public ResponseEntity<List<PlumblingChecklist>> getAllChecklistPlumbling(){
		return new ResponseEntity<>(plumblingservice.getAllPlumbingChecklist(),HttpStatus.OK);
	}
	
	@PostMapping("/addTaskPlumbingChecklist")
	public ResponseEntity<List<TaskPlumblingChecklist>> addTaskPlumbling(@RequestBody List<TaskPlumblingChecklist> checklist){
		List<TaskPlumblingChecklist> savedChecklist = plumblingservice.addTaskPlumbingChecklist(checklist);
		return new ResponseEntity<>(savedChecklist,HttpStatus.OK);
	}
	
	@GetMapping("/getBydateTaskPlumbling/{date}/{storeName}")
	public ResponseEntity<List<TaskPlumblingChecklist>> getTaskPlumbling(@PathVariable("date") String date,@PathVariable("storeName") String storeName){
		List<TaskPlumblingChecklist> savedChecklist = plumblingservice.getbyDateTaskPlumbling(date);
		return new ResponseEntity<>(savedChecklist,HttpStatus.OK);
	}
}
