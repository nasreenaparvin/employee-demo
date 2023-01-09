package com.axis.asmstakeholders.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stakeholder")
public class Stakeholder {
	
	
	@Id
	private  String stakeholderId;
	
	private String stakeholderName;
	private String projectId;
	private String stakeholderEmail;
	private long stakeholderMobileNo;
	
	
	public Stakeholder() {
		super();
	}


	public Stakeholder(String stakeholderId, String stakeholderName, String projectId, String stakeholderEmail,
			long stakeholderMobileNo) {
		super();
		this.stakeholderId = stakeholderId;
		this.stakeholderName = stakeholderName;
		this.projectId = projectId;
		this.stakeholderEmail = stakeholderEmail;
		this.stakeholderMobileNo = stakeholderMobileNo;
	}


	public String getStakeholderId() {
		return stakeholderId;
	}


	public void setStakeholderId(String stakeholderId) {
		this.stakeholderId = stakeholderId;
	}


	public String getStakeholderName() {
		return stakeholderName;
	}


	public void setStakeholderName(String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getStakeholderEmail() {
		return stakeholderEmail;
	}


	public void setStakeholderEmail(String stakeholderEmail) {
		this.stakeholderEmail = stakeholderEmail;
	}


	public long getStakeholderMobileNo() {
		return stakeholderMobileNo;
	}


	public void setStakeholderMobileNo(long stakeholderMobileNo) {
		this.stakeholderMobileNo = stakeholderMobileNo;
	}


	@Override
	public String toString() {
		return "Stakeholder [stakeholderId=" + stakeholderId + ", stakeholderName=" + stakeholderName + ", projectId="
				+ projectId + ", stakeholderEmail=" + stakeholderEmail + ", stakeholderMobileNo=" + stakeholderMobileNo
				+ "]";
	}
	
	


	

	
	
	
	

}
