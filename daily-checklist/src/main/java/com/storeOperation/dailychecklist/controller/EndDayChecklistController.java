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

import com.storeOperation.dailychecklist.entity.EndDayChecklist;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.service.EndDayChecklistService;

@RestController
@RequestMapping("/api/dayChecklist")
public class EndDayChecklistController {

	@Autowired
	private EndDayChecklistService endDayChecklistService;
	
	@PostMapping("/addEndChecklist")
	public ResponseEntity<String> createEndChecklist(@RequestBody EndDayChecklist endDayChecklist){
		String savedCheckList = endDayChecklistService.endcheckListadd(endDayChecklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/view/EndCheckList/{date}")
	public ResponseEntity<EndDayChecklist> seeEndCheckList(@PathVariable String date){
		EndDayChecklist startcheckList = endDayChecklistService.viewendCheckList(date);
		return new ResponseEntity<>(startcheckList,HttpStatus.OK);
	}
	
	@PostMapping("/updateEndChecklist/{date}")
	public ResponseEntity<EndDayChecklist> upadteChecklist(@RequestBody EndDayChecklist endDayChecklist,@PathVariable("date") String date){
		EndDayChecklist savedCheckList = endDayChecklistService.updateEndChecklist(date, endDayChecklist);
		return new ResponseEntity<>(savedCheckList,HttpStatus.OK);
	}

}
