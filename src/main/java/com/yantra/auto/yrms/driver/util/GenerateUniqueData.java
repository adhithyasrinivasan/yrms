package com.yantra.auto.yrms.driver.util;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.MongoDBConnector;

public class GenerateUniqueData 
{
	private static MongoDatabase mongoDb;
	public static void connectDb()
	{
		GlobalSettings settings=new GlobalSettings();
		mongoDb=MongoDBConnector.connectMongoDb();
	}
	public static String uniqueZip()
	{
		String zipcode=null;
		while(zipcode==null)
		{
			zipcode=RandomStringUtils.randomNumeric(5);
			if(checkZipcode(zipcode))
			{
				zipcode=null;
			}
		}
		return zipcode;
	}
	public static String uniquePhone()
	{
		String phone=null;
		while(phone==null)
		{
			phone=RandomStringUtils.random(10,"9876543210");
			if(checkPhone(phone))
			{
				phone=null;
			}
		}
		return phone;
	}
	public static String uniquePayeePhone()
	{
		String phone=null;
		while(phone==null)
		{
			phone=RandomStringUtils.random(10,"9876543210");
			if(checkSecondaryPhone(phone))
			{
				phone=null;
			}
		}
		return phone;
	}
	public static String uniqueTransactionNumber()
	{
		return RandomStringUtils.randomNumeric(10);
	}
	private static boolean checkZipcode(String value)
	{
		boolean decision=false;
		String zipcode=null;
		FindIterable<Document> customerDocument=mongoDb.getCollection("transactionDocument").find();
		if(customerDocument!=null)
		{
			for(Document document:customerDocument)
			{
				try
				{
					Document accountHolder=(Document) document.get("mAccountHolder"); 
					Document address =(Document) accountHolder.get("address");
					zipcode=address.getString("zipCode");
					if(zipcode.equalsIgnoreCase(value))
					{
						decision=true;
						break;
					}
				}
				catch(NullPointerException ex)
				{
					decision=false;
				}
			}
		}
		return decision;
	}
	
	private static boolean checkPhone(String value)
	{
		boolean decision=false;
		String phone=null;
		FindIterable<Document> customerDocument=mongoDb.getCollection("transactionDocument").find();
		if(customerDocument!=null)
		{
			for(Document document:customerDocument)
			{
				try
				{
					Document accountHolder=(Document) document.get("mAccountHolder");
					Document contact =(Document) accountHolder.get("contact");
					phone=contact.getString("primaryPhone");
					if(phone.equalsIgnoreCase(value))
					{
						decision=true;
						break;
					}
				}
				catch(NullPointerException ex)
				{
					decision=false;
				}
			}
		}
		return decision;
	}
	private static boolean checkSecondaryPhone(String value)
	{
		boolean decision=false;
		String phone=null;
		FindIterable<Document> customerDocument=mongoDb.getCollection("transactionDocument").find();
		if(customerDocument!=null)
		{
			for(Document document:customerDocument)
			{
				try
				{
					Document accountHolder=(Document) document.get("sAccountHolder");
					Document contact =(Document) accountHolder.get("contact");
					phone=contact.getString("primaryPhone");
					if(phone.equalsIgnoreCase(value))
					{
						decision=true;
						break;
					}
				}
				catch(NullPointerException ex)
				{
					decision=false;
				}
			}
		}
		return decision;
	}
	/*public static boolean checkRuleName(String value)
	{
		boolean decision=false;
		String ruleName=null;
		FindIterable<Document> ruleDocument=MongoDBConnector.database.getCollection("rule").find();
		if(ruleDocument!=null)
		{
			for(Document document:ruleDocument)
			{
				ruleName=document.getString("name");
				if(ruleName.equalsIgnoreCase(value))
				{
					decision=true;
					break;
				}
			}
		}
		return decision;
	}*/
	public static boolean checkRuleName(String ruleName)
	{
		boolean decision=false;
		BasicDBObject where = new BasicDBObject();
		where.append("name", ruleName);
		FindIterable<Document> ruleDocument=MongoDBConnector.database.getCollection("rule").find(where);
		if(ruleDocument.iterator().hasNext())
			decision=true;
		else
			decision=false;
		return decision;
	}
	
	public static void main(String args[])
	{
		connectDb();
		
	}
}
