package com.group.retail.services.utils;

import java.util.HashMap;
import java.util.Map;

import com.group.retail.model.Shop;

public class ApplicationUtils {

	private static final Map<Integer, Shop> SHOPDATA = new HashMap<Integer, Shop>();
	
	public static void addShop(Shop shop) {
		
		if(!SHOPDATA.containsKey(shop.shopAddress.postCode)) {
			SHOPDATA.put(shop.shopAddress.postCode, shop);
		}
		
		System.out.println("Shop Added in inmemory");
	}
	
	public static void cleanDataMap() {
		SHOPDATA.clear();
	}
	
	public static Shop getShopData(int postCode) {
		return SHOPDATA.get(postCode);
	}
}
