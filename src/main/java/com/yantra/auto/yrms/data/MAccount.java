package com.yantra.auto.yrms.data;

public class MAccount {
	private String accountNumber;

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	private String accountType;

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	private String currencyCode;

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	private String routingNumber;

	public String getRoutingNumber() {
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	private Institution institution;

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	private String expiryDate;

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	private String transactionAmount;

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	private String accountStatus;

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	private String runningBalance;
	public String getRunningBalance() {
		return runningBalance;
	}

	public void setRunningBalance(String runningBalance) {
		this.runningBalance = runningBalance;
	}

	public String getTrialBalance() {
		return trialBalance;
	}

	public void setTrialBalance(String trialBalance) {
		this.trialBalance = trialBalance;
	}

	public String getHoldBalance() {
		return holdBalance;
	}

	public void setHoldBalance(String holdBalance) {
		this.holdBalance = holdBalance;
	}

	private String trialBalance; 
	private String holdBalance;
	
}
