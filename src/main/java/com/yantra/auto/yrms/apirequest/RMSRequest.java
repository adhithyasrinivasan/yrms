package com.yantra.auto.yrms.apirequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yantra.auto.yrms.data.*;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.InputData;
import com.yantra.auto.yrms.driver.util.DateUtil;
import com.yantra.auto.yrms.driver.util.GenerateUniqueData;
import com.yantra.auto.yrms.driver.util.GetMachineFingerprint;

public class RMSRequest 
{
	public static ObjectMapper mapper=new ObjectMapper();
	private static Address  primaryAddress = new Address();
	private static Address  secondaryAddress = new Address();
	private static Contact  primaryContact = new Contact();
	private static Contact  secondaryContact = new Contact();
	private static Institution institution = new Institution();
	private static Institution secondaryInstitution = new Institution();
	private static MAccount mAccount = new MAccount();
	private static MAccountHolder maccountHolder = new MAccountHolder();
	private static MachineFingerPrint machineFingerPrint=new MachineFingerPrint();
	private static MainRequest yrmsRequest=new MainRequest();
	private static ReqList reqList = new ReqList();
	private static ArrayList<ReqList> sreqList = new ArrayList<ReqList>();
	private static SAccount saccount = new SAccount();
	private static SAccountHolder sAccountHolder = new SAccountHolder();
	private static Terminal terminal = new Terminal();
	public static List<List<String>> maccountInputData;
	public static List<List<String>> saccountInputData;
	public static List<List<String>> transactionInputData;
	public static List<List<String>> participantInputData;
	public static void loadData() 
	{
		maccountInputData=InputData.data.get("MACCOUNT_INFO");
		saccountInputData=InputData.data.get("SACCOUNT_INFO");
		transactionInputData=InputData.data.get("TRANSACTION_DATA");
		participantInputData=InputData.data.get("PARTICIPANT_INFO");
	}
	public static String formRequest() throws JsonProcessingException 
	{
		/*maccountInputData=InputData.data.get("MACCOUNT_INFO");
		saccountInputData=InputData.data.get("SACCOUNT_INFO");
		transactionInputData=InputData.data.get("TRANSACTION_DATA");*/
		loadData();
		/**Maccount Data**/
		mAccount.setAccountNumber(maccountInputData.get(0).get(0));
		mAccount.setAccountType(maccountInputData.get(0).get(1));
		mAccount.setAccountStatus(maccountInputData.get(0).get(25));
		mAccount.setCurrencyCode(maccountInputData.get(0).get(2));
		mAccount.setRoutingNumber(maccountInputData.get(0).get(3));
		mAccount.setRunningBalance(maccountInputData.get(0).get(26));
		mAccount.setTrialBalance(maccountInputData.get(0).get(27));
		mAccount.setHoldBalance(maccountInputData.get(0).get(28));
		institution.setInstitutionId(maccountInputData.get(0).get(4));
		institution.setInstitutionName(maccountInputData.get(0).get(5));
		mAccount.setTransactionAmount(maccountInputData.get(0).get(6));
		mAccount.setExpiryDate(maccountInputData.get(0).get(7));
		mAccount.setInstitution(institution);
		/**Maccount Holder Data**/
		maccountHolder.setHolderId(maccountInputData.get(0).get(8));
		maccountHolder.setHolderName(maccountInputData.get(0).get(9));
		maccountHolder.setCustomerOperator(maccountInputData.get(0).get(10));
		maccountHolder.setCustomerType(maccountInputData.get(0).get(11));
		maccountHolder.setDateOfEstablishment(maccountInputData.get(0).get(12));
		maccountHolder.setCustomerNumber(maccountInputData.get(0).get(13));
		maccountHolder.setHolderIdType(maccountInputData.get(0).get(14));
		maccountHolder.setDateOfBirth(maccountInputData.get(0).get(15));
		primaryAddress.setAddressLine1(maccountInputData.get(0).get(16));
		primaryAddress.setAddressLine2(maccountInputData.get(0).get(17));
		primaryAddress.setNeighborhood(maccountInputData.get(0).get(18));
		primaryAddress.setCity(maccountInputData.get(0).get(19));
		primaryAddress.setState(maccountInputData.get(0).get(20));
		primaryAddress.setZipCode(maccountInputData.get(0).get(21));
		primaryAddress.setCountryCode(maccountInputData.get(0).get(22));
		maccountHolder.setAddress(primaryAddress);
		primaryContact.setPrimaryPhone(maccountInputData.get(0).get(23));
		primaryContact.setPrimaryEmail(maccountInputData.get(0).get(24));
		maccountHolder.setContact(primaryContact);
		yrmsRequest.setTransactionType(transactionInputData.get(0).get(0));
		yrmsRequest.setTransactionAmount(transactionInputData.get(0).get(1));
		yrmsRequest.setTransactionCode(transactionInputData.get(0).get(2));
		yrmsRequest.setFeeAmount(transactionInputData.get(0).get(3));
		yrmsRequest.setTransactionDateTime(DateUtil.getCurrentMilliTime());
		yrmsRequest.setTransactionNumber(transactionInputData.get(0).get(5));
		yrmsRequest.setStatus(transactionInputData.get(0).get(6));
		yrmsRequest.setSettlementType(transactionInputData.get(0).get(7));
		yrmsRequest.setProcessingCode(transactionInputData.get(0).get(9));
		yrmsRequest.setOriginCountryCode(transactionInputData.get(0).get(10));
		yrmsRequest.setRecivingCountryCode(transactionInputData.get(0).get(11));
		yrmsRequest.setDistanceHome(transactionInputData.get(0).get(12));
		saccount.setTransactionAmount(saccountInputData.get(0).get(0));
		saccount.setAccountNumber(saccountInputData.get(0).get(1));
		saccount.setCurrencyCode(saccountInputData.get(0).get(2));
		saccount.setExpiryDate(saccountInputData.get(0).get(3));
		saccount.setAccountType(saccountInputData.get(0).get(4));
		saccount.setAccountStatus(saccountInputData.get(0).get(25));
		saccount.setRoutingNumber(saccountInputData.get(0).get(5));
		saccount.setRunningBalance(saccountInputData.get(0).get(26));
		saccount.setTrialBalance(saccountInputData.get(0).get(27));
		saccount.setHoldBalance(saccountInputData.get(0).get(28));
		secondaryInstitution.setInstitutionId(saccountInputData.get(0).get(6));
		secondaryInstitution.setInstitutionName(saccountInputData.get(0).get(7));
		saccount.setInstitution(secondaryInstitution);
		sAccountHolder.setDateOfBirth(saccountInputData.get(0).get(8));
		sAccountHolder.setCustomerOperator(saccountInputData.get(0).get(9));
		sAccountHolder.setCustomerType(saccountInputData.get(0).get(10));
		sAccountHolder.setHolderId(saccountInputData.get(0).get(11));
		sAccountHolder.setHolderIdType(saccountInputData.get(0).get(12));
		sAccountHolder.setDateOfEstablishment(saccountInputData.get(0).get(13));
		sAccountHolder.setCustomerNumber(saccountInputData.get(0).get(14));
		secondaryAddress.setAddressLine1(saccountInputData.get(0).get(15));
		secondaryAddress.setAddressLine2(saccountInputData.get(0).get(16));
		secondaryAddress.setNeighborhood(saccountInputData.get(0).get(17));
		secondaryAddress.setCity(saccountInputData.get(0).get(18));
		secondaryAddress.setState(saccountInputData.get(0).get(19));
		secondaryAddress.setZipCode(saccountInputData.get(0).get(20));
		secondaryAddress.setCountryCode(saccountInputData.get(0).get(21));
		sAccountHolder.setAddress(secondaryAddress);
		sAccountHolder.setHolderName(saccountInputData.get(0).get(22));
		secondaryContact.setPrimaryEmail(saccountInputData.get(0).get(23));
		secondaryContact.setPrimaryPhone(saccountInputData.get(0).get(24));
		sAccountHolder.setContact(secondaryContact);
		terminal.setType(transactionInputData.get(0).get(8));
		terminal.setName(transactionInputData.get(0).get(13));
		terminal.setNumber(transactionInputData.get(0).get(14));
		try 
		{
			machineFingerPrint.setIpAddress(GetMachineFingerprint.getMachineAddress("ipaddress"));
			machineFingerPrint.setMacAddress(GetMachineFingerprint.getMachineAddress("macaddress"));
			machineFingerPrint.setOperatingSystem(GetMachineFingerprint.getOperatingSystem());
			machineFingerPrint.setWebBrowser(GetMachineFingerprint.getBrowserName());
		} 
		catch (Exception e) 
		{
			new Exception("Error in forming request"+e.getMessage());
			e.printStackTrace();
		}
		yrmsRequest.setmAccount(mAccount);
		yrmsRequest.setmAccountHolder(maccountHolder);
		yrmsRequest.setsAccount(saccount);
		yrmsRequest.setsAccountHolder(sAccountHolder);
		yrmsRequest.setTerminal(terminal);
		yrmsRequest.setMachineFingerPrint(machineFingerPrint);
		yrmsRequest.setUUID(UUID.randomUUID().toString().replaceAll("-", "").trim()); 
		if(participantInputData.size()>0){
			forrmParticipantRequest(yrmsRequest);}
		mapper.writeValueAsString(yrmsRequest);
		return mapper.writeValueAsString(yrmsRequest);
		
	}
	public static MainRequest formRawRequest() throws JsonProcessingException 
	{
		/*maccountInputData=InputData.data.get("MACCOUNT_INFO");
		saccountInputData=InputData.data.get("SACCOUNT_INFO");
		transactionInputData=InputData.data.get("TRANSACTION_DATA");*/
		loadData();
		/**Maccount Data**/
		mAccount.setAccountNumber(maccountInputData.get(0).get(0));
		mAccount.setAccountType(maccountInputData.get(0).get(1));
		mAccount.setAccountStatus(maccountInputData.get(0).get(25));
		mAccount.setCurrencyCode(maccountInputData.get(0).get(2));
		mAccount.setRoutingNumber(maccountInputData.get(0).get(3));
		mAccount.setRunningBalance(maccountInputData.get(0).get(26));
		mAccount.setTrialBalance(maccountInputData.get(0).get(27));
		mAccount.setHoldBalance(maccountInputData.get(0).get(28));
		institution.setInstitutionId(maccountInputData.get(0).get(4));
		institution.setInstitutionName(maccountInputData.get(0).get(5));
		mAccount.setTransactionAmount(maccountInputData.get(0).get(6));
		mAccount.setExpiryDate(maccountInputData.get(0).get(7));
		mAccount.setInstitution(institution);
		/**Maccount Holder Data**/
		maccountHolder.setHolderId(maccountInputData.get(0).get(8));
		maccountHolder.setHolderName(maccountInputData.get(0).get(9));
		maccountHolder.setCustomerOperator(maccountInputData.get(0).get(10));
		maccountHolder.setCustomerType(maccountInputData.get(0).get(11));
		maccountHolder.setDateOfEstablishment(maccountInputData.get(0).get(12));
		maccountHolder.setCustomerNumber(maccountInputData.get(0).get(13));
		maccountHolder.setHolderIdType(maccountInputData.get(0).get(14));
		maccountHolder.setDateOfBirth(maccountInputData.get(0).get(15));
		primaryAddress.setAddressLine1(maccountInputData.get(0).get(16));
		primaryAddress.setAddressLine2(maccountInputData.get(0).get(17));
		primaryAddress.setNeighborhood(maccountInputData.get(0).get(18));
		primaryAddress.setCity(maccountInputData.get(0).get(19));
		primaryAddress.setState(maccountInputData.get(0).get(20));
		primaryAddress.setZipCode(maccountInputData.get(0).get(21));
		primaryAddress.setCountryCode(maccountInputData.get(0).get(22));
		maccountHolder.setAddress(primaryAddress);
		primaryContact.setPrimaryPhone(maccountInputData.get(0).get(23));
		primaryContact.setPrimaryEmail(maccountInputData.get(0).get(24));
		maccountHolder.setContact(primaryContact);
		yrmsRequest.setTransactionType(transactionInputData.get(0).get(0));
		yrmsRequest.setTransactionAmount(transactionInputData.get(0).get(1));
		yrmsRequest.setTransactionCode(transactionInputData.get(0).get(2));
		yrmsRequest.setFeeAmount(transactionInputData.get(0).get(3));
		yrmsRequest.setTransactionDateTime(DateUtil.getCurrentMilliTime());
		yrmsRequest.setTransactionNumber(transactionInputData.get(0).get(5));
		yrmsRequest.setStatus(transactionInputData.get(0).get(6));
		yrmsRequest.setSettlementType(transactionInputData.get(0).get(7));
		yrmsRequest.setProcessingCode(transactionInputData.get(0).get(9));
		yrmsRequest.setOriginCountryCode(transactionInputData.get(0).get(10));
		yrmsRequest.setRecivingCountryCode(transactionInputData.get(0).get(11));
		yrmsRequest.setDistanceHome(transactionInputData.get(0).get(12));
		saccount.setTransactionAmount(saccountInputData.get(0).get(0));
		saccount.setAccountNumber(saccountInputData.get(0).get(1));
		saccount.setCurrencyCode(saccountInputData.get(0).get(2));
		saccount.setExpiryDate(saccountInputData.get(0).get(3));
		saccount.setAccountType(saccountInputData.get(0).get(4));
		saccount.setAccountStatus(saccountInputData.get(0).get(25));
		saccount.setRoutingNumber(saccountInputData.get(0).get(5));
		saccount.setRunningBalance(saccountInputData.get(0).get(26));
		saccount.setTrialBalance(saccountInputData.get(0).get(27));
		saccount.setHoldBalance(saccountInputData.get(0).get(28));
		secondaryInstitution.setInstitutionId(saccountInputData.get(0).get(6));
		secondaryInstitution.setInstitutionName(saccountInputData.get(0).get(7));
		saccount.setInstitution(secondaryInstitution);
		sAccountHolder.setDateOfBirth(saccountInputData.get(0).get(8));
		sAccountHolder.setCustomerOperator(saccountInputData.get(0).get(9));
		sAccountHolder.setCustomerType(saccountInputData.get(0).get(10));
		sAccountHolder.setHolderId(saccountInputData.get(0).get(11));
		sAccountHolder.setHolderIdType(saccountInputData.get(0).get(12));
		sAccountHolder.setDateOfEstablishment(saccountInputData.get(0).get(13));
		sAccountHolder.setCustomerNumber(saccountInputData.get(0).get(14));
		secondaryAddress.setAddressLine1(saccountInputData.get(0).get(15));
		secondaryAddress.setAddressLine2(saccountInputData.get(0).get(16));
		secondaryAddress.setNeighborhood(saccountInputData.get(0).get(17));
		secondaryAddress.setCity(saccountInputData.get(0).get(18));
		secondaryAddress.setState(saccountInputData.get(0).get(19));
		secondaryAddress.setZipCode(saccountInputData.get(0).get(20));
		secondaryAddress.setCountryCode(saccountInputData.get(0).get(21));
		sAccountHolder.setAddress(secondaryAddress);
		sAccountHolder.setHolderName(saccountInputData.get(0).get(22));
		secondaryContact.setPrimaryEmail(saccountInputData.get(0).get(23));
		secondaryContact.setPrimaryPhone(saccountInputData.get(0).get(24));
		sAccountHolder.setContact(secondaryContact);
		terminal.setType(transactionInputData.get(0).get(8));
		terminal.setName(transactionInputData.get(0).get(13));
		terminal.setNumber(transactionInputData.get(0).get(14));
		try 
		{
			machineFingerPrint.setIpAddress(GetMachineFingerprint.getMachineAddress("ipaddress"));
			machineFingerPrint.setMacAddress(GetMachineFingerprint.getMachineAddress("macaddress"));
			machineFingerPrint.setOperatingSystem(GetMachineFingerprint.getOperatingSystem());
			machineFingerPrint.setWebBrowser(GetMachineFingerprint.getBrowserName());
		} 
		catch (Exception e) 
		{
			new Exception("Error in forming request"+e.getMessage());
			e.printStackTrace();
		}
		yrmsRequest.setmAccount(mAccount);
		yrmsRequest.setmAccountHolder(maccountHolder);
		yrmsRequest.setsAccount(saccount);
		yrmsRequest.setsAccountHolder(sAccountHolder);
		yrmsRequest.setTerminal(terminal);
		yrmsRequest.setMachineFingerPrint(machineFingerPrint);
		yrmsRequest.setUUID(UUID.randomUUID().toString().replaceAll("-", "").trim()); 
		if(participantInputData.size()>0){
			forrmParticipantRequest(yrmsRequest);}
		mapper.writeValueAsString(yrmsRequest);
		return yrmsRequest;
		
	}
	public static void forrmParticipantRequest(MainRequest mainRequest) throws JsonProcessingException
	{
		List<Participants> participantList = new ArrayList<Participants>();
		for(int i=0;i<participantInputData.size();i++)
		{
			Participants participants = new Participants();
			participants.setFirstName(participantInputData.get(i).get(0));
			participants.setLastName(participantInputData.get(i).get(1));
			participants.setPhone(participantInputData.get(i).get(2));
			participants.setEmail(participantInputData.get(i).get(3));
			participants.setAddressLine1(participantInputData.get(i).get(4));
			participants.setAddressLine2(participantInputData.get(i).get(5));
			participants.setCity(participantInputData.get(i).get(6));
			participants.setState(participantInputData.get(i).get(7));
			participants.setCountry(participantInputData.get(i).get(8));
			participants.setZipCode(participantInputData.get(i).get(9));
			participants.setType(participantInputData.get(i).get(10));
			participants.setCategory(participantInputData.get(i).get(11));
			participants.setRiskPriority(participantInputData.get(i).get(12));
			participants.setAccountWith(participantInputData.get(i).get(13));
			participants.setHolderId(participantInputData.get(i).get(14));
			participants.setHolderType(participantInputData.get(i).get(15));
			participantList.add(i, participants);
		}
		mainRequest.setParticipants(participantList);
	}
	public static String formUniqueNameRequest() throws JsonProcessingException
	{
		formRequest();
		yrmsRequest.getmAccountHolder().getContact().setPrimaryPhone((GenerateUniqueData.uniquePhone()));
		return null;
	}
/*	public static void formBulkRequest() throws JsonProcessingException 
	{
		List<List<String>> maccountInputData=InputData.data.get("MACCOUNT_INFO");
		List<List<String>> maccountHolderInputData=InputData.data.get("MACCOUNT_HOLDER_INFO");
		List<List<String>> saccountInputData=InputData.data.get("SACCOUNT_INFO");
		List<List<String>> saccountHolderInputData=InputData.data.get("SACCOUNT_HOLDER_INFO");
		List<List<String>> transactionInputData=InputData.data.get("TRANSACTION_DATA");
	*/	/**Maccount Data**//*
		mAccount.setAccountNumber(maccountInputData.get(0).get(0));
		mAccount.setAccountType(maccountInputData.get(0).get(1));
		mAccount.setCurrencyCode(maccountInputData.get(0).get(2));
		mAccount.setRoutingNumber(maccountInputData.get(0).get(3));
		institution.setInstitutionId(maccountInputData.get(0).get(4));
		institution.setInstitutionName(maccountInputData.get(0).get(5));
		mAccount.setTransactionAmount(maccountInputData.get(0).get(6));
		mAccount.setExpiryDate(maccountInputData.get(0).get(7));
		mAccount.setInstitution(institution);
	*/	/**Maccount Holder Data**//*
		maccountHolder.setHolderId(maccountHolderInputData.get(0).get(0));
		maccountHolder.setHolderName(maccountHolderInputData.get(0).get(1));
		maccountHolder.setCustomerOperator(maccountHolderInputData.get(0).get(2));
		maccountHolder.setCustomerType(maccountHolderInputData.get(0).get(3));
		maccountHolder.setDateOfEstablishment(maccountHolderInputData.get(0).get(4));
		maccountHolder.setCustomerNumber(maccountHolderInputData.get(0).get(5));
		maccountHolder.setHolderIdType(maccountHolderInputData.get(0).get(6));
		maccountHolder.setDateOfBirth(maccountHolderInputData.get(0).get(7));
		primaryAddress.setAddressLine1(maccountHolderInputData.get(0).get(8));
		primaryAddress.setAddressLine2(maccountHolderInputData.get(0).get(9));
		primaryAddress.setNeighborhood(maccountHolderInputData.get(0).get(10));
		primaryAddress.setCity(maccountHolderInputData.get(0).get(11));
		primaryAddress.setState(maccountHolderInputData.get(0).get(12));
		primaryAddress.setZipCode(maccountHolderInputData.get(0).get(13));
		primaryAddress.setCountryCode(maccountHolderInputData.get(0).get(14));
		maccountHolder.setAddress(primaryAddress);
		primaryContact.setPrimaryPhone(maccountHolderInputData.get(0).get(15));
		primaryContact.setPrimaryEmail(maccountHolderInputData.get(0).get(16));
		maccountHolder.setContact(primaryContact);
		yrmsRequest.setTransactionType(transactionInputData.get(0).get(0));
		yrmsRequest.setTransactionAmount(transactionInputData.get(0).get(1));
		yrmsRequest.setTransactionCode(transactionInputData.get(0).get(2));
		yrmsRequest.setFeeAmount(transactionInputData.get(0).get(3));
		yrmsRequest.setTransactionDateTime(transactionInputData.get(0).get(4));
		yrmsRequest.setTransactionNumber(transactionInputData.get(0).get(5));
		System.out.println(mapper.writeValueAsString(yrmsRequest));
	*/	/*for(int i=0;i<saccountInputData.size();i++)
		{
			for(int j=0;j<saccountHolderInputData.size();j++)
			{
				if(i==j)
				{
					System.out.println(i);
					System.out.println(j);
				}
			}
		}*/ /*
		for (List<String> saccountList : saccountInputData )
		{
				ReqList reqList = new ReqList();
				Institution inst=new Institution();
				SAccount saccount=new SAccount();
				SAccountHolder saccountHolder = new SAccountHolder();
				if (saccountList.size()>=0)
				{
					saccount.setTransactionAmount(saccountList.get(0));
					saccount.setAccountNumber(saccountList.get(1));
					saccount.setCurrencyCode(saccountList.get(2));
					saccount.setExpiryDate(saccountList.get(3));
					saccount.setAccountType(saccountList.get(4));
					saccount.setRoutingNumber(saccountList.get(5));
					inst.setInstitutionId(saccountList.get(6));
					inst.setInstitutionName(saccountList.get(7));
					saccount.setInstitution(inst);
					saccountHolder.setDateOfBirth(saccountList.get(8));
					saccountHolder.setDateOfBirth(saccountList.get(9));
					saccountHolder.setCustomerOperator(saccountList.get(10));
				}
			reqList.setSAccount(saccount);
			sreqList.add(reqList);
		}	
		yrmsRequest.setmAccount(mAccount);
		yrmsRequest.setmAccountHolder(maccountHolder);
		yrmsRequest.setReqList(sreqList);
		try 
		{
			secondaryInstitution.setInstitutionId("");
			secondaryInstitution.setInstitutionName("");
			secondaryAddress.setAddressLine1("11 great canal street");
			secondaryAddress.setAddressLine2("Topeka lane");
			secondaryAddress.setCity("Topeka");
			secondaryAddress.setCountryCode("840");
			secondaryAddress.setState("KS");
			secondaryAddress.setZipCode("");
			sAccountHolder.setAddress(secondaryAddress);
			saccount.setInstitution(secondaryInstitution);
			saccount.setCurrencyCode("USD");
			machineFingerPrint.setIpAddress(GetMachineFingerprint.getMachineAddress("ipaddress"));
			machineFingerPrint.setMacAddress(GetMachineFingerprint.getMachineAddress("macaddress"));
			machineFingerPrint.setOperatingSystem(GetMachineFingerprint.getOperatingSystem());
			machineFingerPrint.setWebBrowser(GetMachineFingerprint.getBrowserName());
			yrmsRequest.setMachineFingerPrint(machineFingerPrint);
			mapper.writeValueAsString(yrmsRequest);
			System.out.println(mapper.writeValueAsString(yrmsRequest));
		} 
		catch (Exception e) 
		{
			new Exception("Error in forming request"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public static void main(String args[]) throws Exception
	{
		GlobalSettings gs=new GlobalSettings();
		GenerateUniqueData.connectDb();
		InputData.loadInputData();
		RMSRequest.formUniqueNameRequest();
		
	}
}
