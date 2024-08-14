
package com.invensis.request;

import java.util.List;

public class EmpRequest {

	private PersonalDetailsRequest personalDetails;
	private ContactRequest contactDetails;
	private ProfessionDetailsRequest professionDetails;
	private List<EducationRequest> educationDetails;
	
	public PersonalDetailsRequest getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetailsRequest personalDetails) {
		this.personalDetails = personalDetails;
	}
	public ContactRequest getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(ContactRequest contactDetails) {
		this.contactDetails = contactDetails;
	}
	public ProfessionDetailsRequest getProfessionDetails() {
		return professionDetails;
	}
	public void setProfessionDetails(ProfessionDetailsRequest professionDetails) {
		this.professionDetails = professionDetails;
	}
	public List<EducationRequest> getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(List<EducationRequest> educationDetails) {
		this.educationDetails = educationDetails;
	}
	
}
