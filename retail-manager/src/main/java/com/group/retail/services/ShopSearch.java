package com.group.retail.services;

import com.group.retail.model.Shop;

/**
 * The ShopSearch interface defines all public business behaviors for
 * operations on the Retail Management.
 * 
 * This interface should be injected into ShopSearch clients, not the
 * implementation bean.
 * 
 * @author Abhishek Verma
 */
public interface ShopSearch {

	/**
     * Search the nearest shop on the basis on Longitude and Latitude.
     * @param (double Latitude, double Longitude).
     * @return Shop object.
     */
	public Shop searchShopByLatLng(double lat, double lng);
}
