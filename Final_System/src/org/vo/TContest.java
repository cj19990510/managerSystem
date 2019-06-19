package org.vo;

import java.util.Date;

/**
 * TContest entity. @author MyEclipse Persistence Tools
 */

public class TContest implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CName;
	private String CLevel;
	private String CSponsorUnit;
	private String COrganizerUnit;
	private String CIntroduction;
	private String CPicture;
	private Date CTime;

	// Constructors

	/** default constructor */
	public TContest() {
	}

	/** full constructor */
	public TContest(String CName, String CLevel, String CSponsorUnit,
			String COrganizerUnit, String CIntroduction, String CPicture,
			Date CTime) {
		this.CName = CName;
		this.CLevel = CLevel;
		this.CSponsorUnit = CSponsorUnit;
		this.COrganizerUnit = COrganizerUnit;
		this.CIntroduction = CIntroduction;
		this.CPicture = CPicture;
		this.CTime = CTime;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCLevel() {
		return this.CLevel;
	}

	public void setCLevel(String CLevel) {
		this.CLevel = CLevel;
	}

	public String getCSponsorUnit() {
		return this.CSponsorUnit;
	}

	public void setCSponsorUnit(String CSponsorUnit) {
		this.CSponsorUnit = CSponsorUnit;
	}

	public String getCOrganizerUnit() {
		return this.COrganizerUnit;
	}

	public void setCOrganizerUnit(String COrganizerUnit) {
		this.COrganizerUnit = COrganizerUnit;
	}

	public String getCIntroduction() {
		return this.CIntroduction;
	}

	public void setCIntroduction(String CIntroduction) {
		this.CIntroduction = CIntroduction;
	}

	public String getCPicture() {
		return this.CPicture;
	}

	public void setCPicture(String CPicture) {
		this.CPicture = CPicture;
	}

	public Date getCTime() {
		return this.CTime;
	}

	public void setCTime(Date CTime) {
		this.CTime = CTime;
	}

}