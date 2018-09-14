package com.myproject.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.myproject.entity.Kanban;

public class KanbanInfo {
	private int id;
	private String userName;
	private String jobName;
	private java.sql.Date cvDate;
	private java.sql.Date interviewDate;
	private java.sql.Date jobOfferDate;
	private boolean isJobOffer;
	private KanbanInfo kanbanInfo;
	// Upload file.
	private CommonsMultipartFile fileData;
	private boolean newKanban;
	private List<KanbanInfo> kanbanInfoList;

	public KanbanInfo() {
	}

	public KanbanInfo(Kanban kanban) {
		this.id = kanban.getId();
		this.userName = kanban.getUserName();
		this.jobName = kanban.getJobName();
		this.cvDate = kanban.getCVDate();
		this.interviewDate = kanban.getInterviewDate();
		this.jobOfferDate = kanban.getJobOfferDate();
		this.isJobOffer = kanban.getIsJobOffer();
	}

	@Autowired
	public KanbanInfo(int id, String userName, String jobName,
			java.sql.Date CVDate, java.sql.Date interviewDate,
			java.sql.Date jobOfferDate, boolean isJobOffer) {
		this.userName = userName;
		this.jobName = jobName;
		this.cvDate = CVDate;
		this.interviewDate = interviewDate;
		this.jobOfferDate = jobOfferDate;
		this.isJobOffer = isJobOffer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public java.sql.Date getCVDate() {
		return cvDate;
	}

	public void setCVDate(java.sql.Date cvDate) {
		this.cvDate = cvDate;
	}

	public java.sql.Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(java.sql.Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public java.sql.Date getJobOfferDate() {
		return jobOfferDate;
	}

	public void setJobOfferDate(java.sql.Date jobOfferDate) {
		this.jobOfferDate = jobOfferDate;
	}

	public boolean getIsJobOffer() {
		return isJobOffer;
	}

	public void setIsJobOffer(boolean isJobOffer) {
		this.isJobOffer = isJobOffer;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	public boolean isNewKanban() {
		return newKanban;
	}

	public void setNewKanban(boolean newKanban) {
		this.newKanban = newKanban;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public KanbanInfo getKanbanInfo() {
		return kanbanInfo;
	}

	public void setKanbanInfo(KanbanInfo kanbanInfo) {
		this.kanbanInfo = kanbanInfo;
	}

	public List<KanbanInfo> getkanbanInfoList() {
		return kanbanInfoList;
	}

	public void setkanbanInfoList(List<KanbanInfo> kanbanInfoList) {
		this.kanbanInfoList = kanbanInfoList;
	}

}