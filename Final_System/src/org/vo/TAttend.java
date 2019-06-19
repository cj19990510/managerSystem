package org.vo;

/**
 * TAttend entity. @author MyEclipse Persistence Tools
 */

public class TAttend implements java.io.Serializable {

	// Fields

	private Integer CId;
	private Integer CWorksId;
	private String CStuName;
	private String CIsTeamWork;
	private String CIsTeamLeader;
	private String CLeaderStuName;

	// Constructors

	/** default constructor */
	public TAttend() {
	}

	/** full constructor */
	public TAttend(Integer CWorksId, String CStuName, String CIsTeamWork,
			String CIsTeamLeader, String CLeaderStuName) {
		this.CWorksId = CWorksId;
		this.CStuName = CStuName;
		this.CIsTeamWork = CIsTeamWork;
		this.CIsTeamLeader = CIsTeamLeader;
		this.CLeaderStuName = CLeaderStuName;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public Integer getCWorksId() {
		return this.CWorksId;
	}

	public void setCWorksId(Integer CWorksId) {
		this.CWorksId = CWorksId;
	}

	public String getCStuName() {
		return this.CStuName;
	}

	public void setCStuName(String CStuName) {
		this.CStuName = CStuName;
	}

	public String getCIsTeamWork() {
		return this.CIsTeamWork;
	}

	public void setCIsTeamWork(String CIsTeamWork) {
		this.CIsTeamWork = CIsTeamWork;
	}

	public String getCIsTeamLeader() {
		return this.CIsTeamLeader;
	}

	public void setCIsTeamLeader(String CIsTeamLeader) {
		this.CIsTeamLeader = CIsTeamLeader;
	}

	public String getCLeaderStuName() {
		return this.CLeaderStuName;
	}

	public void setCLeaderStuName(String CLeaderStuName) {
		this.CLeaderStuName = CLeaderStuName;
	}

}