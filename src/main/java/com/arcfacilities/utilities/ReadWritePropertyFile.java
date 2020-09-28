package com.arcfacilities.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ReadWritePropertyFile {
	static String testDataPath = System.getProperty("user.dir")
			+ "/src/main/resources/testData.properties";

	public static void setTestData(String key, String data) {
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();
			File file = new File(testDataPath);
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			configProperty.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			configProperty.store(fileOut, "Test Data");
		} catch (Exception ex) {
			Reporter.log("Properties file not found" + ex);
		} finally {

			try {
				fileOut.close();
			} catch (IOException ex) {
				Reporter.log("Properties file not found" + ex);
			}
		}
	}
	
	public static void setTestData(String key, Object ObjectData) {
		String data = ObjectData.toString();
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();
			File file = new File(testDataPath);
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			configProperty.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			configProperty.store(fileOut, "Test Data");
		} catch (Exception ex) {
			Reporter.log("Properties file not found" + ex);
		} finally {

			try {
				fileOut.close();
			} catch (IOException ex) {
				Reporter.log("Properties file not found" + ex);
			}
		}
	}
	
	public static void setTestData(String key, int intData) {
		String data =  Integer.toString(intData) ;
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();
			File file = new File(testDataPath);
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			configProperty.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			configProperty.store(fileOut, "Test Data");
		} catch (Exception ex) {
			Reporter.log("Properties file not found" + ex);
		} finally {

			try {
				fileOut.close();
			} catch (IOException ex) {
				Reporter.log("Properties file not found" + ex);
			}
		}
	}

	public static String getTestData(String key) {
		try {
			FileReader reader = new FileReader(testDataPath);
			Properties p = new Properties();
			p.load(reader);
			return p.getProperty(key);
		} catch (Exception ex) {
			Reporter.log("" + ex);
			return null;
		}

	}
	
	public static String getTestData(String key, String filePath) {
		try {
			FileReader reader = new FileReader(filePath);
			Properties p = new Properties();
			p.load(reader);
			return p.getProperty(key);
		} catch (Exception ex) {
			Reporter.log("" + ex);
			return null;
		}

	}

}
