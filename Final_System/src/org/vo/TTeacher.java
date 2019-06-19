package org.vo;

/**
 * TTeacher entity. @author MyEclipse Persistence Tools
 */

public class TTeacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private String CTeacherId;
	private String CPasswd;
	private String CName;
	private String CPhone;
	private String CMail;
	private String CIsAttend;
	private String CIsCheck;

	// Constructors

	/** default constructor */
	public TTeacher() {
	}

	/** full constructor */
	public TTeacher(String CTeacherId, String CPasswd, String CName,
			String CPhone, String CMail, String CIsAttend, String CIsCheck) {
		this.CTeacherId = CTeacherId;
		this.CPasswd = CPasswd;
		this.CName = CName;
		this.CPhone = CPhone;
		this.CMail = CMail;
		this.CIsAttend = CIsAttend;
		this.CIsCheck = CIsCheck;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCTeacherId() {
		return this.CTeacherId;
	}

	public void setCTeacherId(String CTeacherId) {
		this.CTeacherId = CTeacherId;
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

	public String getCIsAttend() {
		return this.CIsAttend;
	}

	public void setCIsAttend(String CIsAttend) {
		this.CIsAttend = CIsAttend;
	}

	public String getCIsCheck() {
		return this.CIsCheck;
	}

	public void setCIsCheck(String CIsCheck) {
		this.CIsCheck = CIsCheck;
	}

}