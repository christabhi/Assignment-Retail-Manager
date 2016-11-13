package com.group.retail.services;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.retail.AbstractTest;

public class GoogleGeoServiceTest extends AbstractTest {

	@Autowired
	public GoogleGeoService geoService;
	
	@Test
	public void getLatLongTest() {
	
		int postCode = 411014;
		Map<String, Double> data = geoService.getLatLong(postCode);
		
		Assert.assertNotNull(data);
	}
	
	@Test
	public void getLatLongAsNullTest() {
		
		int postCode = 0000;
		Map<String, Double> data = geoService.getLatLong(postCode);
		
		Assert.assertNull(data);
	}
}
