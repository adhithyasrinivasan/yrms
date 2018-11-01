package com.yantra.auto.yrms.apirequest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yantra.auto.yrms.data.YrmsRiskResult;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.InputData;

public class RestTransaction 
{
	public static void initiateYrmsTransaction() throws ClientProtocolException, IOException, UnsupportedOperationException
	{
		RestService service=new RestService();
		RMSRequest.formRequest();
		RestService.postYrmsRequest(RMSRequest.formRequest());
		String isApi=GlobalSettings.getProperty("isApi");
		if(isApi.equalsIgnoreCase("true"))
		{
			RestService.callOfacApi(YrmsRiskResult.getTransactionNumber());	
		}
	}
	public static void initiateYrmsQueueTransaction() throws Exception
	{
		QueueService service=new QueueService();
		RMSRequest.formRequest();
		QueueService.postQueueRmsRequest(RMSRequest.formRequest());
		Thread.sleep(1000);
	}
	public static void initiateYrmsQueueTransaction(String req) throws Exception
	{
			QueueService service=new QueueService();
			String json=RMSRequest.formRequest();
			QueueService.postQueueRmsRequest(req);
			Thread.sleep(1000);
	}
	public static void main(String args[]) throws Exception
	{
		InputData.loadInputData();
		GlobalSettings gs = new GlobalSettings();
		initiateYrmsQueueTransaction();
	}
}
