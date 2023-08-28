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

import com.storeOperation.dailychecklist.dto.SUbChecklistDto;
import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;
import com.storeOperation.dailychecklist.service.HouseKeepingChecklistService;

@RestController
@RequestMapping("/api/dayChecklist")
public class HouseKeepingChecklistController {
	
	@Autowired
	private HouseKeepingChecklistService houseKeppingService;
	
	
	@PostMapping("/addHouseChecklistType")
	public ResponseEntity<String> createHouseChecklistType(@RequestBody HousekeepingChecklist checklist){
		String savedCheckList = houseKeppingService.addHouseChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addSubHouseChecklistType")
	public ResponseEntity<String> createSubHouseChecklistType(@RequestBody SUbChecklistDto checklist){
		String savedCheckList = houseKeppingService.addSubHouseChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addTaskHouseChecklistType")
	public ResponseEntity<List<TaskHousekeepingChecklist>> addTaskHouseChecklistType(@RequestBody List<TaskHousekeepingChecklist> checklist){
		List<TaskHousekeepingChecklist> savedCheckList = houseKeppingService.addTaskHouseChecklist(checklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getTaskHouseChecklist/{date}/{housecheck}/{storeName}")
	public ResponseEntity<List<TaskHousekeepingChecklist>> getTaskHouseChecklist(@PathVariable("date") String date,@PathVariable("housecheck") String housecheck,@PathVariable("storeName") String storeName){
		List<TaskHousekeepingChecklist> savedCheckList = houseKeppingService.getTaskDoneHouseChecklist(date, housecheck,storeName);
		return new ResponseEntity<>(savedCheckList,HttpStatus.OK);
	}
	
	@GetMapping("/getAllHouseKeepingChecklistType")
	public ResponseEntity<List<HousekeepingChecklist>> getAllHosueChecklist(){
		return new ResponseEntity<>(houseKeppingService.getHouseKeeping(),HttpStatus.OK);
	}

	@GetMapping("/getAllSubHousekeepingChecklist/{checklistType}")
	public ResponseEntity<List<SubHousekeepingChecklist>> getAllSubchecklist(@PathVariable("checklistType") String checkListType){
		return new ResponseEntity<>(houseKeppingService.getAllSubHouseKeepingChecklist(checkListType), HttpStatus.OK);
	}
}
