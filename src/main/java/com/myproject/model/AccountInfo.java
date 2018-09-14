package com.myproject.model;
 
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.myproject.entity.Account;
 
public class AccountInfo {
    private String userName;
    private String password;
    private boolean active;
    private String userRole;
 
    private boolean newAccount=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public AccountInfo() {
    }
 
    public AccountInfo(Account account) {
        this.userName = account.getUserName();
        this.active = account.getIsActive();
        this.password= account.getPassword();
        this.userRole = account.getUserRole();
    }
 
    // Không thay đổi Constructor này,
    // nó được sử dụng trong Hibernate query.
    public AccountInfo(String userName, boolean active, String password,String userRole) {
        this.userName= userName;
        this.active = active;
        this.password = password;
        this.userRole = userRole;
    }
 
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName= userName;
    }
    
    
    public boolean getIsActive() {
        return active;
    }
     public void setIsActiv(boolean active) {
        this.active = active;
    }
     
    
     public void setPassword(String password) {
         this.password = password;
     }
  
     public String getPassword() {
         return password;
     }
     
     
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
 
    public String getUserRole() {
        return userRole;
    }
 
   
    
  
 ///_______________________________________________
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewAccount() {
        return newAccount;
    }
 
    public void setNewAccount(boolean newAccount) {
        this.newAccount = newAccount;
    }

	
 
}