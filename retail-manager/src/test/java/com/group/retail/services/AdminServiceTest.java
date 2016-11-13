package com.group.retail.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.retail.AbstractTest;
import com.group.retail.model.Shop;
import com.group.retail.model.ShopAddress;
import com.group.retail.services.utils.ApplicationUtils;

public class AdminServiceTest extends AbstractTest {

	@Autowired
	private AdminService adminService;
	
	@Before
	public void setUp() {
		ApplicationUtils.cleanDataMap();
	}
	
	@Test
	public void addShopTest() {
		
		Shop shop = new Shop();
		ShopAddress address = new ShopAddress();
		
		address.number = 1;
		address.postCode = 411014;
		
		shop.shopName = "TestShop1";
		shop.shopAddress = address;
		
		boolean result = adminService.addShopAddress(shop);
		
		Assert.assertTrue(result);
		Assert.assertNotNull(ApplicationUtils.getShopData(411014));
	}
	
	@Test
	public void failedToAddShopTest() {
		
		Shop shop = new Shop();
		ShopAddress address = new ShopAddress();
		
		address.number = 1;
		address.postCode = 0000;
		
		shop.shopName = "TestShop1";
		shop.shopAddress = address;
		
		boolean result = adminService.addShopAddress(shop);
		
		Assert.assertFalse(result);
		Assert.assertNull(ApplicationUtils.getShopData(411014));
	}
}
