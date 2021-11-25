package com.lpatop.dto;

public class CustomerDto {
	private String FIRSTNAME;
	private String EMAIL;
	private String PHONENUMBER;

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPhoneNumber() {
		return PHONENUMBER;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PHONENUMBER = phoneNumber;
	}

}
