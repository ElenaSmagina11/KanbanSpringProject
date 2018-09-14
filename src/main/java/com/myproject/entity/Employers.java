package com.myproject.entity;
 
import java.io.Serializable;
import java.util.Date;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
///
@Table(name = "Employers")
public class Employers implements Serializable {
 
    private static final long serialVersionUID = -1000119078147252957L;
 
    private String emplName;
    private String emplCity;
    private String emplVacancy;
    
//    private byte[] image;
 
    // For sort.
    private Date createDate;
 
    public Employers() {
    }
 
    @Id
    @Column(name = "empl_name", length = 255, nullable = false)
    public String getEmplName() {
        return emplName;
    }
 
    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }
 
    @Column(name = "empl_city", length = 255, nullable = false)
    public String getEmplCity() {
        return emplCity;
    }
 
    public void setEmplCity(String emplCity) {
        this.emplCity = emplCity;
    }
 
    @Column(name = "empl_vacancy", length = 255, nullable = false)
    public String getEmplVacancy() {
        return emplVacancy;
    }
 
    public void setEmplVacancy(String emplVacancy) {
        this.emplVacancy = emplVacancy;
    }
 
    
    @Override
    public String toString()  {
        return "["+ this.emplName+","+ this.emplCity+","+ this.emplVacancy+"]";
    }
    
//    @Temporal(TemporalType.TIMESTAMP)
//  ///  @Column(emplCity = "Create_Date", nullable = false)
//    @Column(name = "Date", nullable = false)
//    public Date getCreateDate() {
//        return createDate;
//    }
// 
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
// ubrat zagrusku foto 
//    @Lob
//    @Column(emplCity = "Image", length = Integer.MAX_VALUE, nullable = true)
//    public byte[] getImage() {
//        return image;
//    }
// 
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
 
}