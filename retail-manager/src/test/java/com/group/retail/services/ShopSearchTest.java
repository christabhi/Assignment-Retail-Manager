package com.group.retail.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.retail.AbstractTest;
import com.group.retail.model.Shop;
import com.group.retail.model.ShopAddress;
import com.group.retail.services.utils.ApplicationUtils;

public class ShopSearchTest extends AbstractTest {

	@Autowired
	private ShopSearch shopSearch;
	
	@Before
	public void setUp() {
		ApplicationUtils.cleanDataMap();
	}
	
	@Test
	public void testSearch() {
		prepareData();
		
		Shop shop = shopSearch.searchShopByLatLng(56, -5);
		
		Assert.assertNotNull(shop);
		Assert.assertEquals("shop4", shop.shopName);
		Assert.assertEquals("Same Latitude", "55.907", String.valueOf(shop.shopLatitude));
		Assert.assertEquals("Same Longitude", "-4.533", String.valueOf(shop.shopLongitude));
	}
	
	@Test
	public void testSearchShopNotFound() {
		Shop shop = shopSearch.searchShopByLatLng(-18, -78);
		Assert.assertNull(shop);
	}
	
	private void prepareData() {
		
		ShopAddress address1 = new ShopAddress();
		address1.number = 1;
		address1.postCode = 111111;
		
		Shop shop1 = new Shop();
		shop1.shopName = "shop1";
		shop1.shopLatitude = 57.6494;
		shop1.shopLongitude = -3.5606;
		
		shop1.shopAddress = address1;
		
		ApplicationUtils.addShop(shop1);
		
		ShopAddress address2 = new ShopAddress();
		address2.number = 2;
		address2.postCode = 222222;
		
		Shop shop2 = new Shop();
		shop2.shopName = "shop2";
		shop2.shopLatitude = 57.077;
		shop2.shopLongitude = -2.836;
		
		shop2.shopAddress = address2;
		
		ApplicationUtils.addShop(shop2);
		
		ShopAddress address3 = new ShopAddress();
		address3.number = 3;
		address3.postCode = 333333;
		
		Shop shop3 = new Shop();
		shop3.shopName = "shop3";
		shop3.shopLatitude = 57.206;
		shop3.shopLongitude = -2.202;
		
		shop3.shopAddress = address3;
		
		ApplicationUtils.addShop(shop3);
		
		ShopAddress address4 = new ShopAddress();
		address4.number = 4;
		address4.postCode = 444444;
		
		Shop shop4 = new Shop();
		shop4.shopName = "shop4";
		shop4.shopLatitude = 55.907;
		shop4.shopLongitude = -4.533;
		
		shop4.shopAddress = address4;
		
		ApplicationUtils.addShop(shop4);
		
		ShopAddress address5 = new ShopAddress();
		address5.number = 4;
		address5.postCode = 444444;
		
		Shop shop5 = new Shop();
		shop5.shopName = "shop5";
		shop5.shopLatitude = 55.515;
		shop5.shopLongitude = -4.585;
		
		shop5.shopAddress = address5;
		
		ApplicationUtils.addShop(shop5);
		
		ShopAddress address6 = new ShopAddress();
		address6.number = 4;
		address6.postCode = 444444;
		
		Shop shop6 = new Shop();
		shop6.shopName = "shop6";
		shop6.shopLatitude = 56.326;
		shop6.shopLongitude = -3.729;
		
		shop6.shopAddress = address6;
		
		ApplicationUtils.addShop(shop6);
	}
}
