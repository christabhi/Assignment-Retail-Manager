package com.group.retail.services.utils;

import org.junit.Assert;
import org.junit.Test;

import com.group.retail.AbstractTest;

public class GoogleGeoServiceHttpRequestTest extends AbstractTest {

	private GoogleGeoServiceHttpRequest request = new GoogleGeoServiceHttpRequest();
	
	@Test
	public void googleGeoHttpRequestTest() {
		
		int postCode = 41014;
		String response = request.googleGeoService(postCode);
		
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains("OK"));
	}
	
	@Test
	public void googleGeoHttpRequestGetNullTest() {
		
		int postCode = 0000;
		String response = request.googleGeoService(postCode);
		
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains("ZERO_RESULTS"));
	}
}
