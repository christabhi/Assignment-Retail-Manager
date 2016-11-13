package com.group.retail.services;

import java.util.Map;

/**
 * The GoogleGeoService interface defines all public business behaviors for
 * operations on the Geo Location.
 * 
 * This interface should be injected into GoogleGeoService clients, not the
 * implementation bean.
 * 
 * @author Abhishek Verma
 */
public interface GoogleGeoService {

	/**
     * Find the Latitude and Longitude of the postCode
     * @param: (int postCode)
     * @return:  Map<String, Double> of Latitude and Longitude
     */
	public Map<String, Double> getLatLong(int postCode);
}
