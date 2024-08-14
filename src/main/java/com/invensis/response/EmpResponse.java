package com.invensis.response;

import java.util.List;

import com.invensis.entity.Contact;
import com.invensis.entity.Education;
import com.invensis.entity.PersonalDetails;
import com.invensis.entity.ProfessionDetails;

public class EmpResponse {

	private PersonalDetails personalDetails;
	private Contact contactDetails;
	private ProfessionDetails professionDetails;
	private List<Education> educationDetails;
	
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public Contact getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(Contact contactDetails) {
		this.contactDetails = contactDetails;
	}
	public ProfessionDetails getProfessionDetails() {
		return professionDetails;
	}
	public void setProfessionDetails(ProfessionDetails professionDetails) {
		this.professionDetails = professionDetails;
	}
	public List<Education> getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(List<Education> educationDetails) {
		this.educationDetails = educationDetails;
	}
	
	
	
}
