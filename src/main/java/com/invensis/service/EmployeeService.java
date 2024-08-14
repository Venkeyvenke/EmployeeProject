package com.invensis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invensis.entity.Contact;
import com.invensis.entity.Education;
import com.invensis.entity.PersonalDetails;
import com.invensis.entity.ProfessionDetails;
import com.invensis.repo.ContactRepo;
import com.invensis.repo.EducationRepo;
import com.invensis.repo.PersonalDetailsRepo;
import com.invensis.repo.ProfessionDetailsRepo;
import com.invensis.request.ContactRequest;
import com.invensis.request.EducationRequest;
import com.invensis.request.EmpRequest;
import com.invensis.request.PersonalDetailsRequest;
import com.invensis.request.ProfessionDetailsRequest;
import com.invensis.response.EmpResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private ContactRepo contactRepo;
	
	@Autowired
	private EducationRepo educationRepo;
	
	@Autowired
	private PersonalDetailsRepo personalDetails;
	
	@Autowired
	private ProfessionDetailsRepo professionDetailsRepo;

	public String postData(EmpRequest empRequest) {
		ContactRequest contactDetails = empRequest.getContactDetails();
		List<EducationRequest> educationDetails = empRequest.getEducationDetails();
		PersonalDetailsRequest personalDetails2 = empRequest.getPersonalDetails();
		ProfessionDetailsRequest professionDetails = empRequest.getProfessionDetails();
		
		PersonalDetails personalDetailsEntity = exchangePersonalDetailsEntity(personalDetails2);
		PersonalDetails save = personalDetails.save(personalDetailsEntity);
		Contact exchangeContactEntity = exchangeContactEntity(contactDetails,save.getId());
		List<Education> exchangeEducationEntity = exchangeEducationEntity(educationDetails,save.getId());
		ProfessionDetails exchangeprofessionDetailsEntity = exchangeprofessionDetailsEntity(professionDetails,save.getId());
		
		contactRepo.save(exchangeContactEntity);
		educationRepo.saveAll(exchangeEducationEntity);
		professionDetailsRepo.save(exchangeprofessionDetailsEntity);
		return "Data Successfully Stored";
	}

	
	private ProfessionDetails exchangeprofessionDetailsEntity(ProfessionDetailsRequest profession, int id) {
		ProfessionDetails pdr = new ProfessionDetails();
		pdr.setEmpId(id);
		pdr.setJobTile(profession.getJobTile());
		pdr.setCompanyName(profession.getCompanyName());
		pdr.setSalary(profession.getSalary());
		double tdsCalculation = tdsCalculation(profession.getSalary());
		pdr.setTds(tdsCalculation);
		return pdr;
	}


	private double tdsCalculation(double salary) {
		double tds = 0;
		if(salary< 300000) {
			tds = 0;
		}else if(salary >= 300001 && salary <= 700000) {
			tds = (5 / 100) * salary;
		}else if(salary >= 700001 && salary <= 1000000) {
			tds = (10 / 100) * salary;
		}else if(salary >= 1000001 && salary <= 1200000) {
			tds = (15 / 100) * salary;
		}else if(salary >= 1200001 && salary <= 1500000) {
			tds = (20 / 100) * salary;
		}else if(salary >= 1500001) {
			tds = (30 / 100) * salary;
		}
		
		return tds;
	}


	private PersonalDetails exchangePersonalDetailsEntity(PersonalDetailsRequest personal) {
		PersonalDetails pd = new PersonalDetails();
		pd.setfName(personal.getfName());
		pd.setlName(personal.getlName());
		pd.setFather(personal.getFather());
		pd.setMother(personal.getMother());
		pd.setGender(personal.getGender());
		pd.setAge(personal.getAge());
		pd.setMstatus(personal.getMstatus());
		pd.setAddress(personal.getAddress());
		return pd;
	}


	private Contact exchangeContactEntity(ContactRequest contactDetails, int id) {
		Contact c = new Contact();
		c.setEmpId(id);
		c.setMobile(contactDetails.getMobile());
		c.setEmail(contactDetails.getEmail());
		c.setInsta(contactDetails.getInsta());
		c.setFacebook(contactDetails.getFacebook());
		return c;
	}
	private List<Education> exchangeEducationEntity(List<EducationRequest> educationDetails, int id) {
		List<Education> le = new ArrayList<Education>();
		for(EducationRequest ee:educationDetails) {
			Education e = new Education();
			e.setEmpId(id);
			e.setCourse(ee.getCourse());
			e.setInstituteName(ee.getInstituteName());
			e.setYear(ee.getYear());
			e.setPercentage(ee.getPercentage());
			le.add(e);
		}
		return le;
	}


	public List<EmpResponse> getAllData() {
		List<EmpResponse> empList = new ArrayList<EmpResponse>();
		
		
		List<PersonalDetails> personal = personalDetails.findAll();
		for(PersonalDetails person:personal) {
			EmpResponse employee = new EmpResponse();
			Contact contct = contactRepo.findByEmpId(person.getId()).get();
			ProfessionDetails professionDetails = professionDetailsRepo.findByEmpId(person.getId()).get();
			List<Optional<Education>> byEmpId = educationRepo.findByEmpId(person.getId());
			List<Education>  educatioList= new ArrayList<Education>();
			for(Optional<Education> id:byEmpId) {
				Education education = id.get();
				educatioList.add(education);				
			}
			employee.setPersonalDetails(person);
			employee.setContactDetails(contct);
			employee.setProfessionDetails(professionDetails);
			employee.setEducationDetails(educatioList);
			empList.add(employee);
		}		
		return empList;
	}

}
