package org.vo;

/**
 * TStudent entity. @author MyEclipse Persistence Tools
 */

public class TStudent implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CStuId;
	private String CPasswd;
	private String CName;
	private String CClass;
	private String CQq;
	private String CPhone;
	private String CMail;
	private String CIdentityCard;
	private String CWorkunitOrSchool;

	// Constructors

	/** default constructor */
	public TStudent() {
	}

	/** full constructor */
	public TStudent(String CStuId, String CPasswd, String CName, String CClass,
			String CQq, String CPhone, String CMail, String CIdentityCard,
			String CWorkunitOrSchool) {
		this.CStuId = CStuId;
		this.CPasswd = CPasswd;
		this.CName = CName;
		this.CClass = CClass;
		this.CQq = CQq;
		this.CPhone = CPhone;
		this.CMail = CMail;
		this.CIdentityCard = CIdentityCard;
		this.CWorkunitOrSchool = CWorkunitOrSchool;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCStuId() {
		return this.CStuId;
	}

	public void setCStuId(String CStuId) {
		this.CStuId = CStuId;
	}

	public String getCPasswd() {
		return this.CPasswd;
	}

	public void setCPasswd(String CPasswd) {
		this.CPasswd = CPasswd;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCClass() {
		return this.CClass;
	}

	public void setCClass(String CClass) {
		this.CClass = CClass;
	}

	public String getCQq() {
		return this.CQq;
	}

	public void setCQq(String CQq) {
		this.CQq = CQq;
	}

	public String getCPhone() {
		return this.CPhone;
	}

	public void setCPhone(String CPhone) {
		this.CPhone = CPhone;
	}

	public String getCMail() {
		return this.CMail;
	}

	public void setCMail(String CMail) {
		this.CMail = CMail;
	}

	public String getCIdentityCard() {
		return this.CIdentityCard;
	}

	public void setCIdentityCard(String CIdentityCard) {
		this.CIdentityCard = CIdentityCard;
	}

	public String getCWorkunitOrSchool() {
		return this.CWorkunitOrSchool;
	}

	public void setCWorkunitOrSchool(String CWorkunitOrSchool) {
		this.CWorkunitOrSchool = CWorkunitOrSchool;
	}

}