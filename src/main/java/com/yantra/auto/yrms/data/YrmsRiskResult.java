package com.yantra.auto.yrms.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class YrmsRiskResult {
	private String result;
	private String detail;
	private Ofac ofac;
	private String sanctionWatchListHit;
	private String internalTransactionNumber;
	private static String transactionNumber;
	@JsonIgnore
	private ParticipantResult participantSuperNumber = new ParticipantResult();
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Ofac getOfac() {
		return ofac;
	}
	public void setOfac(Ofac ofac) {
		this.ofac = ofac;
	}
	public String getSanctionWatchListHit() {
		return sanctionWatchListHit;
	}
	public void setSanctionWatchListHit(String sanctionWatchListHit) {
		this.sanctionWatchListHit = sanctionWatchListHit;
	}
	public String getInternalTransactionNumber() {
		return internalTransactionNumber;
	}
	public void setInternalTransactionNumber(String internalTransactionNumber) {
		this.internalTransactionNumber = internalTransactionNumber;
	}
	public static String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	@JsonIgnore
	public ParticipantResult getParticipantSuperNumber() {
		return participantSuperNumber;
	}
	@JsonIgnore
	public void setParticipantSuperNumber(ParticipantResult participantSuperNumber) {
		this.participantSuperNumber = participantSuperNumber;
	}
	
}
class ParticipantResult
{
	private String holderId;

	public String getHolderId() {
		return holderId;
	}

	public void setHolderId(String holderId) {
		this.holderId = holderId;
	}
	
}
