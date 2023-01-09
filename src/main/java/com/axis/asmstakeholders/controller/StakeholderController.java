package com.axis.asmstakeholders.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.asmstakeholders.entity.Stakeholder;
import com.axis.asmstakeholders.service.StakeholderService;

@RestController
public class StakeholderController {
	
	
	@Autowired
	private StakeholderService stakeholderService;
	
	

	public StakeholderController() {
		super();
	}

	public StakeholderService getStakeholderService() {
		return stakeholderService;
	}

	public void setStakeholderService(StakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}
//....................Get Mapping.............................
	@GetMapping("/stakeholders")
	public List<Stakeholder> getAllStakeholders(){
		return stakeholderService.getAllStakeholders();
	}
	
	@GetMapping("/stakeholders/{stakeholderId}")
	public Stakeholder getStakeholderById(@PathVariable String stakeholderId){
		return stakeholderService.getStakeholderById(stakeholderId);
	}
	

	@GetMapping("/stakeholders-count")
	public long countOfStakeholders() {
		return stakeholderService.getCountOfRows();
	}
	//...................post mapping....................................
	
	@PostMapping("/newstakeholder")
	public ResponseEntity<String> saveStakeholder(@RequestBody Stakeholder stakeholder){
		stakeholderService.saveStakeholder(stakeholder);
		return new ResponseEntity<String>("stakeholder added to db...",HttpStatus.CREATED);
	}
	//..............delete mapping.......................
	
	@DeleteMapping("/stakeholders/{stakeholderId}")
	public ResponseEntity<String> deleteStakeholderById(@PathVariable String stakeholderId){
		stakeholderService.deleteStakeholderById(stakeholderId);
		return new ResponseEntity<String>("stakeholder is deleted from db...",HttpStatus.OK);
	}
	//............................put mapping.................
	@PutMapping("/stakeholders/{stakeholderId}")
	public ResponseEntity<String> updateStakeholder(@PathVariable String stakeholderId,@RequestBody Stakeholder newStakeholder){
		if(!stakeholderId.equals(newStakeholder.getStakeholderId())) {
			return new ResponseEntity<String>("stakeholder updated successfully....", HttpStatus.BAD_REQUEST);
		}
		else {
			stakeholderService.updateStakeholder(stakeholderId, newStakeholder);
			return new ResponseEntity<String>("stakeholder updated successfully....", HttpStatus.CREATED);
		}
	}

}
