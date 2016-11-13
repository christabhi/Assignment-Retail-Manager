package com.group.retail.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.retail.services.utils.GoogleGeoServiceHttpRequest;

@Service
public class GoogleGeoServiceImpl implements GoogleGeoService {

	/**
	 * The logger for this class hierarchy
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private GoogleGeoServiceHttpRequest httpRequest = new GoogleGeoServiceHttpRequest();
	
	private ObjectMapper mapper = new ObjectMapper();
	
	TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};

	
	@Override
	public Map<String, Double> getLatLong(int postCode) {
		
		logger.info("GoogleGeoService.getLatLong");
		
		String response = httpRequest.googleGeoService(postCode);
		
		Map<String, Double> latLngMap = extractLatlongFromResponse(response);
		
		return latLngMap;
	}
	
	private Map<String, Double> extractLatlongFromResponse(String response) {
		
		Map<String, Double> latLong = null;
		JsonNode node = null;
		
		try {
			node = mapper.readTree(response);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!node.get("status").asText().equals("ZERO_RESULTS")) {
			
			if(node.has("results")) {
				
				JsonNode results = node.path("results").get(0);
				
				double latitude = 0.0;
				double longitude = 0.0;
				
				if(results.has("geometry") && results.path("geometry").has("location") && results.path("geometry").path("location").has("lat")) 
				{
					latitude = results.path("geometry").path("location").path("lat").doubleValue();
				}
				
				if(results.has("geometry") && results.path("geometry").has("location") && results.path("geometry").path("location").has("lng")) 
				{
					longitude = results.path("geometry").path("location").path("lng").doubleValue();
				}
				
				if(latitude > 0.0 && longitude > 0.0) {
					
					latLong = new HashMap<String, Double>();
					
					latLong.put("latitude", latitude);
					latLong.put("longitude", longitude);
				}
				
			}
		}
		
		return latLong;
	}

}
