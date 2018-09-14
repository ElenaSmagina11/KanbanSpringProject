package com.myproject.model;
 
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.myproject.entity.Employers;
 
public class EmployerInfo {
    private String emplName;
    private String emplCity;
    private String emplVacancy;
    
 
    private boolean newEmployer=false;
    private EmployerInfo employerInfo;
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public EmployerInfo() {
    }
 
    public EmployerInfo(Employers employers) {
        this.emplName = employers.getEmplName();
        this.emplCity = employers.getEmplCity();
        this.emplVacancy = employers.getEmplVacancy();
    }
 
    // Không thay đổi Constructor này,
    // nó được sử dụng trong Hibernate query.
    public EmployerInfo(String emplName, String emplCity, String emplVacancy) {
        this.emplName = emplName;
        this.emplCity = emplCity;
        this.emplVacancy = emplVacancy;
        		
    }
 
    public String getEmplName() {
        return emplName;
    }
 
    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }
 
    public String getEmplCity() {
        return emplCity;
    }
 
    public void setEmplCity(String emplCity) {
        this.emplCity = emplCity;
    }
 
    public String getEmplVacancy() {
        return emplVacancy;
    }
 
    public void setEmplVacancy(String emplVacancy) {
        this.emplVacancy = emplVacancy;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
//for registration?
    public boolean isNewEmployer() {
        return newEmployer;
    }
 
    public void setNewEmployer(boolean newEmployer) {
        this.newEmployer = newEmployer;
    }

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public EmployerInfo getEmployerInfo() {
        return employerInfo;
    }
 
    public void setEmployerInfo(EmployerInfo employerInfo) {
        this.employerInfo = employerInfo;
    }
 
}