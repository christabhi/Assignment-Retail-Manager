package com.group.retail.services;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.retail.model.Shop;
import com.group.retail.services.utils.ApplicationUtils;

/**
 * The AdminServiceImpl encapsulates all business behaviors operating on the
 * Shop entity model object.
 * 
 * @author Abhishek Verma
 */
@Service
public class AdminServiceImpl implements AdminService {

	/**
	 * The logger for this class hierarchy
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
     * The Google Geo Service to fetch Latitude and Longitude using postCode.
     */
	@Autowired
	public GoogleGeoService geoService;
	
	@Override
	public boolean addShopAddress(Shop shop) {
		
		boolean isAdded = false;
		Map<String, Double> latLng = geoService.getLatLong(shop.shopAddress.postCode);
		
		if(latLng != null) {
			
			shop.shopLatitude = latLng.get("latitude");
			shop.shopLongitude = latLng.get("longitude");
			
			ApplicationUtils.addShop(shop);
			
			isAdded = true;
		}
		
		return isAdded;
	}

}
