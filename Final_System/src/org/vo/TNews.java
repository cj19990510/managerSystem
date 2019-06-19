package org.vo;

import java.util.Date;

/**
 * TNews entity. @author MyEclipse Persistence Tools
 */

public class TNews implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CNewsName;
	private String CNewsUrl;
	private Date CNewsTime;

	// Constructors

	/** default constructor */
	public TNews() {
	}

	/** full constructor */
	public TNews(String CNewsName, String CNewsUrl, Date CNewsTime) {
		this.CNewsName = CNewsName;
		this.CNewsUrl = CNewsUrl;
		this.CNewsTime = CNewsTime;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCNewsName() {
		return this.CNewsName;
	}

	public void setCNewsName(String CNewsName) {
		this.CNewsName = CNewsName;
	}

	public String getCNewsUrl() {
		return this.CNewsUrl;
	}

	public void setCNewsUrl(String CNewsUrl) {
		this.CNewsUrl = CNewsUrl;
	}

	public Date getCNewsTime() {
		return this.CNewsTime;
	}

	public void setCNewsTime(Date CNewsTime) {
		this.CNewsTime = CNewsTime;
	}

}