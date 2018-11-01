package com.yantra.auto.yrms.driver.listeners;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer
{

	Properties prop=new Properties();
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		try 
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("testcase_runmode.properties"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if(!prop.values().contains(annotation.getTestName()))
		{
			annotation.setEnabled(false);
		}
	}
}
