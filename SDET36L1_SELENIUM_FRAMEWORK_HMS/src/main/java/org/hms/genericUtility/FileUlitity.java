package org.hms.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class FileUlitity
{
	Properties properties;
	public void  intiallizePropertyFile(String propertyFilePath)
	{
		FileInputStream fis=null;
		try
		{
			fis = new FileInputStream(propertyFilePath);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	    try 
	    {
	    	properties = new Properties();
			properties.load(fis);
		}
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
	public String getDataProperty(String key)
	{
		return properties.getProperty(key).trim();
	}
}
