package com.wcf.tas.entity;

import java.sql.Timestamp;

public class ArticleClassVO {
	
	private int classId;
	private String className;
	private String classEnName;
	private String classRemark;
	private int addUid;
	private Timestamp addDate;
	private Timestamp modifyDate;
	private boolean isShow;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassEnName() {
		return classEnName;
	}
	public void setClassEnName(String classEnName) {
		this.classEnName = classEnName;
	}
	public String getClassRemark() {
		return classRemark;
	}
	public void setClassRemark(String classRemark) {
		this.classRemark = classRemark;
	}
	public int getAddUid() {
		return addUid;
	}
	public void setAddUid(int addUid) {
		this.addUid = addUid;
	}
	
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public Timestamp getAddDate() {
		return addDate;
	}
	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
}
