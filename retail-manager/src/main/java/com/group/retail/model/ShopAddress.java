package com.group.retail.model;

import javax.validation.constraints.NotNull;

public class ShopAddress {

	@NotNull
	public int number;
	
	@NotNull
	public int postCode;
}
