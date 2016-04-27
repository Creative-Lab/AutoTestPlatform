package com.auto.solution.TestDrivers;


import com.auto.solution.Common.*;
public class TestDriverFactory {

	private String testDriverKey = "";
	private ResourceManager rmanager;
	public TestDriverFactory(String Key,ResourceManager rManager){
		Key = Key.toLowerCase().trim();
		this.testDriverKey = Key;
		this.rmanager = rManager;
	}
	
	public TestDrivers getTestDriver(){
		TestDrivers testDriver = null;
	    if(testDriverKey.contains(Property.DESKTOP_WEB_TESTDRIVER_KEYWORD)){
	    	testDriver = new DesktopWebTestDriverImpl(rmanager);
	    }
	    else if(testDriverKey.contains(Property.MOBILE_APP_ANDRIOD_TESTDRIVER_KEYWORD)){
	    	testDriver = new MobileAndriodTestDriverImpl(this.rmanager);
	    }
	    else if(testDriverKey.contains(Property.MOBILE_WEB_TESTDRIVER_KEYWORD)){
	    	testDriver = new MobileWebTestDriverImpl(this.rmanager);
	    }
	    else if(testDriverKey.contains(Property.MOBILE_IOS_TESTDRIVER_KEYWORD)){
	    	testDriver = new MobileIOSTestDriverImpl(this.rmanager);
	    }
	    return testDriver;
	}
}
