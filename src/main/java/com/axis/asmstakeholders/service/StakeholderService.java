package com.axis.asmstakeholders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.asmstakeholders.entity.Stakeholder;
import com.axis.asmstakeholders.repository.StakeholderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StakeholderService {

    @Autowired
	private StakeholderRepository stakeholderRepository;
    
    
	public Stakeholder getStakeholderById(String stakeholderId) {
		return stakeholderRepository.findById(stakeholderId).get();
	}
	
	public List<Stakeholder> getAllStakeholders(){
		return (List<Stakeholder>) stakeholderRepository.findAll();
	}
	
	public void saveStakeholder(Stakeholder stakeholder) {
		stakeholderRepository.save(stakeholder);
	}
	
	public void updateStakeholder(String stakeholderId,Stakeholder newStakeholder) {
		Stakeholder stakeholder=stakeholderRepository.findById(stakeholderId).get();
		stakeholder.setStakeholderName(newStakeholder.getStakeholderName());
		stakeholder.setProjectId(newStakeholder.getProjectId());
		stakeholder.setStakeholderEmail(newStakeholder.getStakeholderEmail());
		stakeholder.setStakeholderMobileNo(newStakeholder.getStakeholderMobileNo());
		stakeholderRepository.save(stakeholder);
	}
	
	public void deleteStakeholderById(String stakeholderId) {
		stakeholderRepository.deleteById(stakeholderId);
	}
	

	public long getCountOfRows() {
		return stakeholderRepository.count();
	}
}
