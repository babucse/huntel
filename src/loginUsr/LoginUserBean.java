package com.loiane.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

import com.bnym.gsss.common.domain.BeanTemplate;

@Entity
@Table(name = "LOGIN_USERS")
public class LoginUserBean extends BeanTemplate{

	@Id
	@TableGenerator(name="THAR_SEQ", table="SEQ_KEY", pkColumnName="NAME", valueColumnName="VALUE", pkColumnValue="LOGIN_USER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="THAR_SEQ")
	@Column(name = "ID", nullable = false)
	private int loginId;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String fName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lName;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "PHONE_NO", nullable = false)
	private String phoneNo;
	
	@Column(name = "RCD_CRD_ID", nullable = false)
	private String recordCreatedId;
	
	@Column(name = "RCD_CRD_DT", nullable = false)
	private Timestamp recordCreatedDt;
	
	@Column(name = "LST_UPDT_ID", nullable = false)
	private String lastUpdatedId;
	
	@Version
	@Column(name = "LST_UPDT_DT", nullable = false)
	private Timestamp lastUpdatedDt;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRecordCreatedId() {
		return recordCreatedId;
	}

	public void setRecordCreatedId(String recordCreatedId) {
		this.recordCreatedId = recordCreatedId;
	}

	public Timestamp getRecordCreatedDt() {
		return recordCreatedDt;
	}

	public void setRecordCreatedDt(Timestamp recordCreatedDt) {
		this.recordCreatedDt = recordCreatedDt;
	}

	public String getLastUpdatedId() {
		return lastUpdatedId;
	}

	public void setLastUpdatedId(String lastUpdatedId) {
		this.lastUpdatedId = lastUpdatedId;
	}

	public Timestamp getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Timestamp lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}
	
	
}

