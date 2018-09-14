package com.myproject.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
 @Table(name = "Kanban")
//@Table(name = "Kanban5")
// kanban mit Date
public class Kanban implements Serializable {

	private static final long serialVersionUID = -1000119078147252957L;
	private int id;
	private String userName;
	private String jobName;
	private Date cvDate;
	private Date interviewDate;
	private Date jobOfferDate;
	private boolean isJobOffer;

	// For sort. private Date createDate;
	public Kanban() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "user_name", length = 30, nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "job_name", length = 30, nullable = false)
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(name = "cv_date", nullable = true)
	public Date getCVDate() {
		return cvDate;
	}

	public void setCVDate(java.util.Date date) {
		this.cvDate = (Date) date;
	}

	@Column(name = "interview_date", nullable = true)
	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(java.util.Date date) {
		this.interviewDate = (Date) date;
	}

	@Column(name = "joboffer_date", length = 10, nullable = true)
	public Date getJobOfferDate() {
		return jobOfferDate;
	}

	public void setJobOfferDate(java.util.Date date) {
		this.jobOfferDate = (Date) date;
	}

	@Column(name = "is_joboffer", length = 1, nullable = false)
	public boolean getIsJobOffer() {
		return isJobOffer;
	}

	public void setIsJobOffer(boolean isJobOffer) {
		this.isJobOffer = isJobOffer;
	}

	// @Temporal(TemporalType.TIMESTAMP)
	// /// @Column(emplCity = "Create_Date", nullable = false)
	// @Column(name = "Date", nullable = false)
	// public Date getCreateDate() {
	// return createDate;
	// }
	//
	// public void setCreateDate(Date createDate) {
	// this.createDate = createDate;
	// }
	// photo upload
	// @Lob
	// @Column(emplCity = "Image", length = Integer.MAX_VALUE, nullable = true)
	// public byte[] getImage() {
	// return image;
	// }
	//
	// public void setImage(byte[] image) {
	// this.image = image;
	// }
	@Override
	public String toString() {
		return "[" + this.id + "," + this.userName + "," + this.jobName + ","
				+ this.cvDate + "," + this.interviewDate + ","
				+ this.jobOfferDate + "," + this.isJobOffer + "]";
	}
}