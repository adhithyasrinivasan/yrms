package com.yantra.auto.yrms.apirequest;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.remote.internal.ApacheHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.yantra.auto.yrms.data.OfacTransactionCall;
import com.yantra.auto.yrms.data.YrmsRiskResult;
import com.yantra.auto.yrms.driver.GlobalSettings;

public class RestService 
{
	public RestService(){	GlobalSettings gs=new GlobalSettings();	}
	/*private static CloseableHttpClient client;
	private static CloseableHttpResponse closeresponse;*/
	private static HttpPost postRequest;
	private static HttpResponse response;
	private static HttpEntity entity;
	private static InputStream content;
	private static CredentialsProvider credentialsProvider()
	{
		CredentialsProvider credentialProvider = new BasicCredentialsProvider();
		String username=GlobalSettings.getProperty(GlobalSettings.restuser);
		String password=GlobalSettings.getProperty(GlobalSettings.restpassword);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		credentialProvider.setCredentials(AuthScope.ANY, credentials);
		return credentialProvider;
	}
	private static HttpResponse executePostRequest(HttpPost postRequest) throws ClientProtocolException, IOException
	{
		CredentialsProvider provider = credentialsProvider();
		HttpClient client=HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
       	HttpResponse response=client.execute(postRequest);
       	return response;
	}
    public static void postYrmsRequest(String json) throws ClientProtocolException, IOException
    {
    	postRequest=new HttpPost(GlobalSettings.getProperty("yrmsurl")+"/"+GlobalSettings.getProperty("apipath"));
    	postRequest.setEntity(new StringEntity(json));
       	response=executePostRequest(postRequest);
		entity=response.getEntity();
		content=entity.getContent();
		String result=EntityUtils.toString(entity);
		ObjectMapper mapper = new ObjectMapper();
		Reader reader = new StringReader(result);
//		mapper.readValue(result, Ofac ofac);
		YrmsRiskResult[] riskResult = mapper.readValue(result, YrmsRiskResult[].class);
		
	}
    public static void callOfacApi(String transactionNumber) throws UnsupportedOperationException, IOException
    {
    	postRequest=new HttpPost(GlobalSettings.getProperty("yrmsurl")+"/rest/transaction/riskScoreWithOFAC");
    	OfacTransactionCall ofacTransaction = new OfacTransactionCall();
      	ofacTransaction.setTransactionNumber(transactionNumber);
      	postRequest.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(ofacTransaction)));
      	response=executePostRequest(postRequest);
		entity=response.getEntity();
		content=entity.getContent();
    }
   
/*    public static void main(String args[]) throws ClientProtocolException, IOException
    {
    	GlobalSettings gs=new GlobalSettings();
    	
    	RestService.postYrmsRequest("");
    }*/
}
