package com.storeOperations.labeloperations.controller;

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

import com.storeOperations.labeloperations.entity.LabelDto;
import com.storeOperations.labeloperations.service.Labelservice;
import com.storeOperations.labeloperations.service.impl.LabelServiceImpl;


@RestController
@RequestMapping("/api/label")
public class LabelController {
	
	@Autowired
	private Labelservice labelService;
	
	@PostMapping("/addLabel")
	public ResponseEntity<String> createLabel(@RequestBody LabelDto labelDto){
		String savedapp = labelService.addLabelandProduct(labelDto);
		return new ResponseEntity<>(savedapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/showLabelInfo/{selfLabelId}/{store}")
	public ResponseEntity<LabelDto> showLabel(@PathVariable("selfLabelId") String selfLabelId,@PathVariable("store") String store){
		LabelDto self = labelService.viewItemInSelf(selfLabelId,store);
		return new ResponseEntity<>(self,HttpStatus.OK);
	}
	
	

}
