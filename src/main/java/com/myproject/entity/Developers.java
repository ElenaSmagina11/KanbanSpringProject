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
@Table(name = "Developers")
public class Developers implements Serializable {
 
    private static final long serialVersionUID = -1000119078147252957L;
 
    private String devName;
    private String devCity;
    private String devJob;
    
//    private byte[] image;
 
    // For sort.
    private Date createDate;
 
    public Developers() {
    }
 
    @Id
    @Column(name = "dev_name", length = 20, nullable = false)
    public String getDevName() {
        return devName;
    }
 
    public void setDevName(String devName) {
        this.devName = devName;
    }
 
    @Column(name = "dev_city", length = 30, nullable = false)
    public String getDevCity() {
        return devCity;
    }
 
    public void setDevCity(String devCity) {
        this.devCity = devCity;
    }
 
    @Column(name = "dev_job", length = 50, nullable = false)
    public String getDevJob() {
        return devJob;
    }
 
    public void setDevJob(String devJob) {
        this.devJob = devJob;
    }
 
    
    @Override
    public String toString()  {
        return "["+ this.devName+","+ this.devCity+","+ this.devJob+"]";
    }
    
//    @Temporal(TemporalType.TIMESTAMP)
//  ///  @Column(devCity = "Create_Date", nullable = false)
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
//    @Column(devCity = "Image", length = Integer.MAX_VALUE, nullable = true)
//    public byte[] getImage() {
//        return image;
//    }
// 
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
 
}