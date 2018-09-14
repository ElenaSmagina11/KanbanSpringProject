package com.myproject.model;
 
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.myproject.entity.Developers;
 
public class DeveloperInfo {
    private String devName;
    private String devCity;
    private String devJob;
    
 
    private boolean newDeveloper=false;
    private DeveloperInfo developerInfo;
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public DeveloperInfo() {
    }
 
    public DeveloperInfo(Developers Developers) {
        this.devName = Developers.getDevName();
        this.devCity = Developers.getDevCity();
        this.devJob = Developers.getDevJob();
    }
 
    // Không thay đổi Constructor này,
    // nó được sử dụng trong Hibernate query.
    public DeveloperInfo(String devName, String devCity, String devJob) {
        this.devName = devName;
        this.devCity = devCity;
        this.devJob = devJob;
        		
    }
 
    public String getDevName() {
        return devName;
    }
 
    public void setDevName(String devName) {
        this.devName = devName;
    }
 
    public String getDevCity() {
        return devCity;
    }
 
    public void setDevCity(String devCity) {
        this.devCity = devCity;
    }
 
    public String getDevJob() {
        return devJob;
    }
 
    public void setDevJob(String devJob) {
        this.devJob = devJob;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
///for registration
    public boolean isNewDeveloper() {
        return newDeveloper;
    }
 
    public void setNewDeveloper(boolean newDeveloper) {
        this.newDeveloper = newDeveloper;
    }

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public DeveloperInfo getDeveloperInfo() {
        return developerInfo;
    }
 
    public void setDeveloperInfo(DeveloperInfo developerInfo) {
        this.developerInfo = developerInfo;
    }
 
}