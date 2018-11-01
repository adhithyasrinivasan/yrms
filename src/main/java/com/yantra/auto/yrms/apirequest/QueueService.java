package com.yantra.auto.yrms.apirequest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.SSLContext;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.SslContextFactory;
import com.yantra.auto.yrms.driver.GlobalSettings;

public class QueueService 
{
	public static void postQueueRmsRequest(String json) throws IOException, TimeoutException, KeyManagementException, NoSuchAlgorithmException
	{
		ConnectionFactory factory = new ConnectionFactory();
    		factory.setHost(GlobalSettings.getProperty("rabbit.connection.host"));
    		factory.setUsername(GlobalSettings.getProperty("rabbit.connection.username"));
    		factory.setPassword(GlobalSettings.getProperty("rabbit.connection.password"));
    		factory.setPort(Integer.parseInt(GlobalSettings.getProperty("rabbit.connection.port")));
    		factory.setVirtualHost(GlobalSettings.getProperty("rabbit.connection.virtual.host"));
    		if(GlobalSettings.getProperty("rabbit.useSSL").equalsIgnoreCase("true")){
    			factory.useSslProtocol(GlobalSettings.getProperty("rabbit.SSL.protocol"));}
    	com.rabbitmq.client.Connection connection = factory.newConnection();
    	Channel channel = connection.createChannel();
    		channel.basicPublish("", GlobalSettings.getProperty("rabbit.connection.queue"), null, json.getBytes());
    		channel.close();
    		connection.close();
	}
	
}
