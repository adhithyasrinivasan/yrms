package com.yantra.auto.yrms.data;

import java.util.ArrayList;
import java.util.List;

public class MainRequest {
	private SAccountHolder sAccountHolder;

	public SAccountHolder getsAccountHolder() {
		return this.sAccountHolder;
	}

	public void setsAccountHolder(SAccountHolder sAccountHolder) {
		this.sAccountHolder = sAccountHolder;
	}

	private SAccount sAccount;

	public SAccount getsAccount() {
		return this.sAccount;
	}

	public void setsAccount(SAccount sAccount) {
		this.sAccount = sAccount;
	}

	private MAccountHolder mAccountHolder;

	public MAccountHolder getmAccountHolder() {
		return this.mAccountHolder;
	}

	public void setmAccountHolder(MAccountHolder mAccountHolder) {
		this.mAccountHolder = mAccountHolder;
	}

	private MAccount mAccount;

	public MAccount getmAccount() {
		return this.mAccount;
	}

	public void setmAccount(MAccount mAccount) {
		this.mAccount = mAccount;
	}

	private MachineFingerPrint machineFingerPrint;

	public MachineFingerPrint getMachineFingerPrint() {
		return this.machineFingerPrint;
	}

	public void setMachineFingerPrint(MachineFingerPrint machineFingerPrint) {
		this.machineFingerPrint = machineFingerPrint;
	}

	private Long transactionDateTime;

	public Long getTransactionDateTime() {
		return this.transactionDateTime;
	}

	public void setTransactionDateTime(Long date) {
		this.transactionDateTime = date;
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

	private Geolocation geoLocation;

	public Geolocation getGeoLocation() {
		return this.geoLocation;
	}

	public void setGeoLocation(Geolocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	private Terminal terminal;

	public Terminal getTerminal() {
		return this.terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	private ArrayList<ReqList> reqList;

	public ArrayList<ReqList> getReqList() {
		return this.reqList;
	}

	public void setReqList(ArrayList<ReqList> reqList) {
		this.reqList = reqList;
	}
	
	private String transactionAmount;

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	private String feeAmount;

	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	private String originalTransactionNumber;

	public String getOriginalTransactionNumber() {
		return originalTransactionNumber;
	}

	public void setOriginalTransactionNumber(String originalTransactionNumber) {
		this.originalTransactionNumber = originalTransactionNumber;
	}
	
	private String status;
	private String message;
    private String productCode;
	
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	private List<Participants> participants = new ArrayList<Participants>();
	

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}
	
	private String settlementType;
	
	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}
	
	private String UUID;
	
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	private String processingCode;

	public String getProcessingCode() {
		return processingCode;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}
	
	private String originCountryCode;
	
	private String recivingCountryCode;
	
	public String getOriginCountryCode() {
		return originCountryCode;
	}

	public void setOriginCountryCode(String originCountryCode) {
		this.originCountryCode = originCountryCode;
	}

	public String getRecivingCountryCode() {
		return recivingCountryCode;
	}

	public void setRecivingCountryCode(String recivingCountryCode) {
		this.recivingCountryCode = recivingCountryCode;
	}
	
	private String distanceHome;
	

	public String getDistanceHome() {
		return distanceHome;
	}

	public void setDistanceHome(String distanceHome) {
		this.distanceHome = distanceHome;
	}

	@Override
	public String toString() {
		return "MainRequest [sAccountHolder=" + sAccountHolder + ", sAccount=" + sAccount + ", mAccountHolder="
				+ mAccountHolder + ", mAccount=" + mAccount + ", machineFingerPrint=" + machineFingerPrint
				+ ", transactionDateTime=" + transactionDateTime + ", transactionNumber=" + transactionNumber
				+ ", transactionType=" + transactionType + ", transactionCode=" + transactionCode + ", geoLocation="
				+ geoLocation + ", terminal=" + terminal + ", reqList=" + reqList + ", transactionAmount="
				+ transactionAmount + ", feeAmount=" + feeAmount + ", originalTransactionNumber="
				+ originalTransactionNumber + ", status=" + status + ", message=" + message +",settlementType ="+settlementType+ ", productCode="
				+ productCode + ",participants="+participants + ",UUID="+UUID+" ]";
	}
	
	
}