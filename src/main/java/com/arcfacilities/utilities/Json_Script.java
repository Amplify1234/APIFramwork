package com.arcfacilities.utilities;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.ParseException;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.arcfacilities.reports.ReporterConstants;
import com.arcfacilities.utilities.DateUtils;
import com.jayway.restassured.response.Header;

public class Json_Script {

	public static String filePath;

	// public static FilePath = "D:\response.json";

	public static boolean json_body(ResponseBody body, String fileName)
			throws org.json.simple.parser.ParseException, ParseException {
		filePath = System.getProperty("user.dir") + "/JSON_Schema/" + fileName + "_responce_body.json";

		JSONParser jsonParser = new JSONParser();

		// Write JSON file
		try (FileWriter file = new FileWriter(filePath)) {

			file.write(body.asString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean json_header(Headers headers, String fileName)
			throws org.json.simple.parser.ParseException, ParseException {
		filePath = System.getProperty("user.dir") + "/JSON_Schema/" + fileName + "_responce_header.properties";
		JSONParser jsonParser = new JSONParser();

		// Write JSON file
		try (FileWriter file = new FileWriter(filePath)) {

			file.write(headers.toString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
