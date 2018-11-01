package com.yantra.auto.yrms.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.yantra.auto.yrms.driver.GlobalSettings;

public class MongoDBConnector extends AutomationBase
{
	public final static String db_url=GlobalSettings.getProperty(GlobalKeys.mongoDbUrl);
	public final static String db_port=GlobalSettings.getProperty(GlobalKeys.mongoDbPort);
	public final static String dbname=GlobalSettings.getProperty(GlobalKeys.mongoDbName);
	public final static String dbuser=GlobalSettings.getProperty(GlobalKeys.mongoDBUser);
	public final static String dbPass=GlobalSettings.getProperty(GlobalKeys.mongoDBPass);
	public final static String dbReplicationUrls=GlobalSettings.getProperty("mongo.replica.url.list");
	private static String authenticationDecision=GlobalSettings.getProperty("isAuth");
	private static int dbport=Integer.parseInt(db_port);
	public static MongoClient mongo;
	public static MongoDatabase database;
	public static MongoDatabase connectMongoDb()
	{
		MongoCredential mongoCredential = MongoCredential.createCredential(dbuser,dbname,dbPass.toCharArray());
		boolean authDecision = Boolean.parseBoolean(authenticationDecision);
		List<ServerAddress> addressList = new ArrayList<ServerAddress>();
		String[] urlList = dbReplicationUrls.split(",");
		for(String replicationUrl : urlList)
		{
			addressList.add(new ServerAddress(replicationUrl));
		}
		if(authDecision){mongo=new MongoClient(addressList,Arrays.asList(mongoCredential));}
		else{mongo=new MongoClient(addressList);}
		database=mongo.getDatabase(dbname);
		return database;
	}
	/*public static MongoDatabase connectnMongoDb()
	{
		ServerAddress serverAddress = new ServerAddress(db_url,dbport);
		MongoCredential mongoCredential = MongoCredential.createCredential(dbuser,dbname,dbPass.toCharArray());
		boolean authDecision = Boolean.parseBoolean(authenticationDecision);
		if(Boolean.parseBoolean(replicationDecision))
		{
			List<ServerAddress> addressList = new ArrayList<ServerAddress>();
			String[] urlList = dbReplicationUrls.split(",");
			for(String replicationUrl : urlList)
			{
				addressList.add(new ServerAddress(replicationUrl));
			}
			if(authDecision)
			{
				mongo=new MongoClient(addressList,Arrays.asList(mongoCredential));
			}
			else{	mongo=new MongoClient(addressList);	}
		}
		else{
			System.out.println("Creating normal server connection");
		if(authDecision)
		{
			mongo=new MongoClient(serverAddress,Arrays.asList(mongoCredential));
		}
		mongo=new MongoClient(serverAddress);}
		database=mongo.getDatabase(dbname);
		return database;
	}*/
	
}
