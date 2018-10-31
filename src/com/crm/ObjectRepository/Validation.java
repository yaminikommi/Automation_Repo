package com.crm.ObjectRepository;

import junit.framework.Assert;

public class Validation {
	public String Verifying(String actual,String expected)
	{
		try
		{
		
			Assert.assertEquals(actual, expected);
		 return "pass";
		}
		catch(AssertionError rv)
		{
			return "fail";
		}
	}

}
