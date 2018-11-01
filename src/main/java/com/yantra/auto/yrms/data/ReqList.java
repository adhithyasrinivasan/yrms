package com.yantra.auto.yrms.data;

public class ReqList {
	private SAccountHolder sAccountHolder;

	public SAccountHolder getSAccountHolder() {
		return this.sAccountHolder;
	}

	public void setSAccountHolder(SAccountHolder sAccountHolder) {
		this.sAccountHolder = sAccountHolder;
	}

	private SAccount sAccount;

	public SAccount getSAccount() {
		return this.sAccount;
	}

	public void setSAccount(SAccount sAccount) {
		this.sAccount = sAccount;
	}

	private String transactionNumber;

	public String getTransactionNumber() {
		return this.transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	private String transactionType;

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	private String transactionCode;

	public String getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
}
