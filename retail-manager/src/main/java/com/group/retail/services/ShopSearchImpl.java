package com.group.retail.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.group.retail.model.Shop;
import com.group.retail.services.utils.ApplicationUtils;
import com.group.retail.services.utils.LocationKDTree;

/**
 * The ShopSearchImpl encapsulates all business behaviors operating on the
 * Shop entity model object.
 * 
 * @author Abhishek Verma
 */
@Service
public class ShopSearchImpl implements ShopSearch {

	/**
	 * The logger for this class hierarchy
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Shop searchShopByLatLng(double lat, double lng) {
		
		return search(lat, lng);
	}
	
	private Shop search(double lat, double lng) {
		
		Shop nearestShop = null;
		
		List<Shop> allShop = new ArrayList<Shop>();
		allShop.addAll(ApplicationUtils.getAllShopData().values());
		
		if(allShop != null && allShop.size() > 0) {
			
			LocationKDTree kdTree = new LocationKDTree(allShop);
			
			nearestShop = kdTree.findNearest(lat, lng);
		}
		
		return nearestShop;
	}
}
