package com.yantra.auto.yrms.driver.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.yantra.auto.yrms.driver.AutomationBase;

public class GetMachineFingerprint 
{
	private static String[] addressArray=new String[5];
	private static String ipAddr=null;
	public static String getMachineAddress(String para) throws Exception
	{
		String addr=null;
		String firstInterface = null;        
	    Map<String, String> addressByNetwork = new HashMap<String, String>();
	    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
	    while(networkInterfaces.hasMoreElements())
	    {
	        NetworkInterface network = networkInterfaces.nextElement();
	        byte[] bmac = network.getHardwareAddress();
	        if(bmac != null)
	        {
	        	StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bmac.length; i++)
	            {
	                sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));        
	            }
	            if(sb.toString().isEmpty()==false)
	            {
	                addressByNetwork.put(network.getName(), sb.toString());
	                //System.out.println("Address = "+sb.toString()+" @ ["+network.getName()+"] "+network.getDisplayName());
	            }
	            if(sb.toString().isEmpty()==false && firstInterface == null)
	            {
	                firstInterface = network.getName();
	            }
	            Enumeration<InetAddress> inetAddresses = network.getInetAddresses();
	            for (InetAddress inetAddress : Collections.list(inetAddresses)) 
	            {
	                ipAddr=inetAddress.getHostAddress();
	            }
	        }
	    }
	    addressArray[1]=addressByNetwork.get(firstInterface);
	    addressArray[0]=ipAddr;
	    if(para.equalsIgnoreCase("ipaddress"))
	    {
	    	addr= addressArray[0];
	    }
	    else if(para.equalsIgnoreCase("macaddress"))
	    {
	    	addr= addressArray[1];
	    }
	    return addr;
	}
	public static String getOperatingSystem()
	{
		return System.getProperty("os.name").toLowerCase();
	}
	public static String getBrowserName()
	{
		return AutomationBase.getBrowser();
	}
	
}
