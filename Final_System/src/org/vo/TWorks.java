package org.vo;

import java.util.Date;

/**
 * TWorks entity. @author MyEclipse Persistence Tools
 */

public class TWorks implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CContestName;
	private String CStuName;
	private String CTeamName;
	private String CTeamNameEn;
	private String CTeamPicture;
	private String CAttendTeacherName;
	private String CAttendLetter;
	private String CChecked;
	private String CCheckedTeacherName;
	private Date CCheckedTime;
	private String CPrize;
	private String CAwardCertificate;
	private String CWorksShow;
	private String CWorksAddress;
	private String CWorksPasswd;
	private String CExperience;

	// Constructors

	/** default constructor */
	public TWorks() {
	}

	/** full constructor */
	public TWorks(String CContestName, String CStuName, String CTeamName,
			String CTeamNameEn, String CTeamPicture, String CAttendTeacherName,
			String CAttendLetter, String CChecked, String CCheckedTeacherName,
			Date CCheckedTime, String CPrize, String CAwardCertificate,
			String CWorksShow, String CWorksAddress, String CWorksPasswd,
			String CExperience) {
		this.CContestName = CContestName;
		this.CStuName = CStuName;
		this.CTeamName = CTeamName;
		this.CTeamNameEn = CTeamNameEn;
		this.CTeamPicture = CTeamPicture;
		this.CAttendTeacherName = CAttendTeacherName;
		this.CAttendLetter = CAttendLetter;
		this.CChecked = CChecked;
		this.CCheckedTeacherName = CCheckedTeacherName;
		this.CCheckedTime = CCheckedTime;
		this.CPrize = CPrize;
		this.CAwardCertificate = CAwardCertificate;
		this.CWorksShow = CWorksShow;
		this.CWorksAddress = CWorksAddress;
		this.CWorksPasswd = CWorksPasswd;
		this.CExperience = CExperience;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCContestName() {
		return this.CContestName;
	}

	public void setCContestName(String CContestName) {
		this.CContestName = CContestName;
	}

	public String getCStuName() {
		return this.CStuName;
	}

	public void setCStuName(String CStuName) {
		this.CStuName = CStuName;
	}

	public String getCTeamName() {
		return this.CTeamName;
	}

	public void setCTeamName(String CTeamName) {
		this.CTeamName = CTeamName;
	}

	public String getCTeamNameEn() {
		return this.CTeamNameEn;
	}

	public void setCTeamNameEn(String CTeamNameEn) {
		this.CTeamNameEn = CTeamNameEn;
	}

	public String getCTeamPicture() {
		return this.CTeamPicture;
	}

	public void setCTeamPicture(String CTeamPicture) {
		this.CTeamPicture = CTeamPicture;
	}

	public String getCAttendTeacherName() {
		return this.CAttendTeacherName;
	}

	public void setCAttendTeacherName(String CAttendTeacherName) {
		this.CAttendTeacherName = CAttendTeacherName;
	}

	public String getCAttendLetter() {
		return this.CAttendLetter;
	}

	public void setCAttendLetter(String CAttendLetter) {
		this.CAttendLetter = CAttendLetter;
	}

	public String getCChecked() {
		return this.CChecked;
	}

	public void setCChecked(String CChecked) {
		this.CChecked = CChecked;
	}

	public String getCCheckedTeacherName() {
		return this.CCheckedTeacherName;
	}

	public void setCCheckedTeacherName(String CCheckedTeacherName) {
		this.CCheckedTeacherName = CCheckedTeacherName;
	}

	public Date getCCheckedTime() {
		return this.CCheckedTime;
	}

	public void setCCheckedTime(Date CCheckedTime) {
		this.CCheckedTime = CCheckedTime;
	}

	public String getCPrize() {
		return this.CPrize;
	}

	public void setCPrize(String CPrize) {
		this.CPrize = CPrize;
	}

	public String getCAwardCertificate() {
		return this.CAwardCertificate;
	}

	public void setCAwardCertificate(String CAwardCertificate) {
		this.CAwardCertificate = CAwardCertificate;
	}

	public String getCWorksShow() {
		return this.CWorksShow;
	}

	public void setCWorksShow(String CWorksShow) {
		this.CWorksShow = CWorksShow;
	}

	public String getCWorksAddress() {
		return this.CWorksAddress;
	}

	public void setCWorksAddress(String CWorksAddress) {
		this.CWorksAddress = CWorksAddress;
	}

	public String getCWorksPasswd() {
		return this.CWorksPasswd;
	}

	public void setCWorksPasswd(String CWorksPasswd) {
		this.CWorksPasswd = CWorksPasswd;
	}

	public String getCExperience() {
		return this.CExperience;
	}

	public void setCExperience(String CExperience) {
		this.CExperience = CExperience;
	}

}