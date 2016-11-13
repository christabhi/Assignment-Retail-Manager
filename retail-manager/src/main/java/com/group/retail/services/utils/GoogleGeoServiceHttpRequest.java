package com.group.retail.services.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The GoogleGeoServiceHttpRequest class is use to make REST using google API to 
 * fetch Longitude and Latitude using postCode.
 * 
 * @author Abhishek Verma
 */
public class GoogleGeoServiceHttpRequest {
	
	/**
	 * The logger for this class hierarchy
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public String googleGeoService(int postCode) {
		
		StringBuffer response = new StringBuffer("");
		try {

			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?components=postal_code:"+postCode);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String output = "";
			logger.info("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				response.append(output);
			}
			conn.disconnect();
			
			logger.info(response.toString());
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return response.toString();
	}
}
