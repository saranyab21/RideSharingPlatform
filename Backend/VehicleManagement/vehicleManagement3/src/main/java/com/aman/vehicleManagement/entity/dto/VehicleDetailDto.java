package com.aman.vehicleManagement.entity.dto;

import java.util.Date;

public class VehicleDetailDto {
	private String rtoName;
	private Date registrationDate;
	private Date registrationExpiresOn;
//	private String rcDocUrl;
	private String insuranceCompanyName;
	private int insuranceNo;
	private Date insurancedOn;
    private Date insuranceExpiresOn;
//    private String insuranceCertificateDocUrl;
    private int pucCertificateNo;
    private Date pucIssuedOn;
    private Date pucValidUntil;
//    private String pucDocUrl;
	public String getRtoName() {
		return rtoName;
	}
	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getRegistrationExpiresOn() {
		return registrationExpiresOn;
	}
	public void setRegistrationExpiresOn(Date registrationExpiresOn) {
		this.registrationExpiresOn = registrationExpiresOn;
	}
//	public String getRcDocUrl() {
//		return rcDocUrl;
//	}
//	public void setRcDocUrl(String rcDocUrl) {
//		this.rcDocUrl = rcDocUrl;
//	}
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public int getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(int insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public Date getInsurancedOn() {
		return insurancedOn;
	}
	public void setInsurancedOn(Date insurancedOn) {
		this.insurancedOn = insurancedOn;
	}
	public Date getInsuranceExpiresOn() {
		return insuranceExpiresOn;
	}
	public void setInsuranceExpiresOn(Date insuranceExpiresOn) {
		this.insuranceExpiresOn = insuranceExpiresOn;
	}
//	public String getInsuranceCertificateDocUrl() {
//		return insuranceCertificateDocUrl;
//	}
//	public void setInsuranceCertificateDocUrl(String insuranceCertificateDocUrl) {
//		this.insuranceCertificateDocUrl = insuranceCertificateDocUrl;
//	}
	public int getPucCertificateNo() {
		return pucCertificateNo;
	}
	public void setPucCertificateNo(int pucCertificateNo) {
		this.pucCertificateNo = pucCertificateNo;
	}
	public Date getPucIssuedOn() {
		return pucIssuedOn;
	}
	public void setPucIssuedOn(Date pucIssuedOn) {
		this.pucIssuedOn = pucIssuedOn;
	}
	public Date getPucValidUntil() {
		return pucValidUntil;
	}
	public void setPucValidUntil(Date pucValidUntil) {
		this.pucValidUntil = pucValidUntil;
	}
//	public String getPucDocUrl() {
//		return pucDocUrl;
//	}
//	public void setPucDocUrl(String pucDocUrl) {
//		this.pucDocUrl = pucDocUrl;
//	}
    
}
