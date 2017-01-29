package com.gamma.air.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@Column(name = "accountId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private int applicantId;
	private int balance;
	private String currency;
	private boolean isPrimary;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", applicantId=" + applicantId + ", balance=" + balance
				+ ", currency=" + currency + ", isPrimary=" + isPrimary + "]";
	}
	
}
