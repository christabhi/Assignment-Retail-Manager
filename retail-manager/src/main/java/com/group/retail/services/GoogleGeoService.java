package com.group.retail.services;

import java.util.Map;

public interface GoogleGeoService {

	public Map<String, Double> getLatLong(int postCode);
}
