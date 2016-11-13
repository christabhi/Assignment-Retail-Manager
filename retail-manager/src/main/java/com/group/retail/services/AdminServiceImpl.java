package com.group.retail.services;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.retail.model.Shop;
import com.group.retail.services.utils.ApplicationUtils;

@Service
public class AdminServiceImpl implements AdminService {

	/**
	 * The logger for this class hierarchy
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public GoogleGeoService geoService;
	
	@Override
	public boolean addShopAddress(Shop shop) {
		
		boolean isAdded = false;
		Map<String, Double> latLng = geoService.getLatLong(shop.shopAddress.postCode);
		
		if(latLng != null) {
			
			shop.shopLatitude = latLng.get("latitude").toString();
			shop.shopLongitude = latLng.get("longitude").toString();
			
			ApplicationUtils.addShop(shop);
			
			isAdded = true;
		}
		
		return isAdded;
	}

}
