package com.yantra.auto.yrms.driver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputData {

	public static Map<String,List<List<String>>> data= new HashMap<String,List<List<String>>>();
	
	public static void loadInputData() throws IOException{
		try {
			List<List<String>> maccount = ExcelConnectivity.readExcel(".//InputTestData", "MAccountData.xls", "MACCOUNT_INFO");
			data.put("MACCOUNT_INFO", maccount);
			List<List<String>> transactionData = ExcelConnectivity.readExcel(".//InputTestData", "MAccountData.xls", "TRANSACTION_DATA");
			data.put("TRANSACTION_DATA", transactionData);
			List<List<String>> saccount = ExcelConnectivity.readExcel(".//InputTestData", "SAccountData.xls", "SACCOUNT_INFO");
			data.put("SACCOUNT_INFO", saccount);
			List<List<String>> participant = ExcelConnectivity.readExcel(".//InputTestData", "SAccountData.xls", "PARTICIPANT_INFO");
			data.put("PARTICIPANT_INFO", participant);
			List<List<String>> usersdata=ExcelConnectivity.readExcel(".//InputTestData", "Users.xls", "USERS_LIST");
			data.put("USERS_LIST",usersdata);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}

