package com.storeOperation.dailychecklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.service.DaliyChecklistService;


@RestController
@RequestMapping("/api/dayChecklist")
public class DailyChecklistController {
	
	@Autowired
	private DaliyChecklistService dailyCheckListService;
	
	@PostMapping("/add")
	public ResponseEntity<String> createChecklist(@RequestBody StartDayChecklist startDayChecklist){
		String savedCheckList = dailyCheckListService.startcheckListadd(startDayChecklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/view/StartCheckList/{date}")
	public ResponseEntity<StartDayChecklist> seeStartCheckList(@PathVariable String date){
		StartDayChecklist startcheckList = dailyCheckListService.viewStartCheckList(date);
		return new ResponseEntity<>(startcheckList,HttpStatus.OK);
	}
	
	@PostMapping("/updateStartChecklist/{date}")
	public ResponseEntity<StartDayChecklist> upadteChecklist(@RequestBody StartDayChecklist startDayChecklist,@PathVariable("date") String date){
		StartDayChecklist savedCheckList = dailyCheckListService.updateStartChecklist(date, startDayChecklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.OK);
	}

}
