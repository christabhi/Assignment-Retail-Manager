package com.group.retail.model;

import javax.validation.constraints.NotNull;

public class Shop {

	@NotNull
	public String shopName;
	
	@NotNull
	public ShopAddress shopAddress;
	
	public String shopLongitude;
	
	public String shopLatitude;
}
