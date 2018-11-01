package com.yantra.auto.yrms.apirequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yantra.auto.yrms.data.*;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.util.DateUtil;
import com.yantra.auto.yrms.driver.util.GenerateUniqueData;
import com.yantra.auto.yrms.driver.util.GetMachineFingerprint;

public class RestRequest 
{
	protected static ObjectMapper mapper=new ObjectMapper();
	public static Map<String,String> uniqueData=new HashMap<String,String>();
	public static Map<String,String> uniquePayeeData=new HashMap<String,String>();
	private static Address  primaryAddress = new Address();
	private static Address  secondaryAddress = new Address();
	private static Contact  contact = new Contact();
	private static Institution institution = new Institution();
	private static Institution institution2 = new Institution();
	private static MAccount maccount = new MAccount();
	private static MAccountHolder maccountHolder = new MAccountHolder();
	private static MachineFingerPrint machineFingerPrint=new MachineFingerPrint();
	private static MainRequest yrmsRequest=new MainRequest();
	private static ReqList reqList = new ReqList();
	private static SAccount saccount = new SAccount();
	private static SAccountHolder sAccountHolder = new SAccountHolder();
	public static void formRestRequest() 
	{
		GenerateUniqueData.connectDb();
		uniqueData.put("phone", GenerateUniqueData.uniquePhone());
		uniqueData.put("transactionNumber", GenerateUniqueData.uniqueTransactionNumber());
		uniqueData.put("zipcode", GenerateUniqueData.uniqueZip());
		uniqueData.put("primaryInstName", "CBW BANK");
		uniqueData.put("primaryInstId", "101115302");
		uniqueData.put("transactionTime",DateUtil.getCurrentDateTime(GlobalSettings.getProperty("dateFormat")));
		uniquePayeeData.put("secondaryPhone", GenerateUniqueData.uniquePhone());
		uniquePayeeData.put("secondaryZipcode", GenerateUniqueData.uniqueZip());
		uniquePayeeData.put("secondaryInstName", "CBW BANK");
		uniquePayeeData.put("secondaryInstId", "101115302");
		try 
		{
			institution.setInstitutionId(uniqueData.get("primaryInstId"));
			institution.setInstitutionName(uniqueData.get("primaryInstName"));
			institution2.setInstitutionId(uniquePayeeData.get("secondaryInstId"));
			institution2.setInstitutionName(uniquePayeeData.get("secondaryInstName"));
			primaryAddress.setAddressLine1("11 great canal street");
			primaryAddress.setAddressLine2("Topeka lane");
			primaryAddress.setCity("Topeka");
			primaryAddress.setCountryCode("840");
			primaryAddress.setState("KS");
			primaryAddress.setZipCode(uniqueData.get("zipcode"));
			secondaryAddress.setAddressLine1("11 great canal street");
			secondaryAddress.setAddressLine2("Topeka lane");
			secondaryAddress.setCity("Topeka");
			secondaryAddress.setCountryCode("840");
			secondaryAddress.setState("KS");
			secondaryAddress.setZipCode(uniquePayeeData.get("secondaryZipcode"));
			contact.setPrimaryPhone(uniqueData.get("phone"));
			maccountHolder.setAddress(primaryAddress);
			maccountHolder.setContact(contact);
			sAccountHolder.setAddress(secondaryAddress);
			maccount.setCurrencyCode("USD");
			maccount.setInstitution(institution);
			maccount.setRoutingNumber(uniqueData.get("primaryInstId"));
			saccount.setInstitution(institution2);
			saccount.setCurrencyCode("USD");
			machineFingerPrint.setIpAddress(GetMachineFingerprint.getMachineAddress("ipaddress"));
			machineFingerPrint.setMacAddress(GetMachineFingerprint.getMachineAddress("macaddress"));
			machineFingerPrint.setOperatingSystem(GetMachineFingerprint.getOperatingSystem());
			machineFingerPrint.setWebBrowser(GetMachineFingerprint.getBrowserName());
			yrmsRequest.setTransactionNumber(uniqueData.get("transactionNumber"));
			yrmsRequest.setmAccountHolder(maccountHolder);
			yrmsRequest.setmAccount(maccount);
			yrmsRequest.setMachineFingerPrint(machineFingerPrint);
			//yrmsRequest.setTransactionDateTime(uniqueData.get("transactionTime"));
			mapper.writeValueAsString(yrmsRequest);
			System.out.println(mapper.writeValueAsString(yrmsRequest));
//			System.out.println(maccountHolder.getAddress().getZipCode());
		} 
		catch (Exception e) 
		{
			new Exception("Error in forming request"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		GlobalSettings gs=new GlobalSettings();
		GenerateUniqueData.connectDb();
		RestRequest.formRestRequest();
	}
}
