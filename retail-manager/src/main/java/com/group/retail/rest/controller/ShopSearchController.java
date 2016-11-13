package com.group.retail.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.retail.model.Shop;
import com.group.retail.model.ShopAddress;
import com.group.retail.services.ShopSearch;

/**
 * The ShopSearchController class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>
 * which, by default, contains a ResponseEntity converted into JSON with an
 * associated HTTP status code.
 * 
 * @author Abhishek Verma
 */
@RestController
@RequestMapping(value = "/shop/search/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopSearchController extends BaseController {

	@Autowired
	private ShopSearch shopSearch;
	
	/**
     * Web service endpoint to search nearest Shop in JSON.
     * @URI: /rms/shop/search/api/v1/search
     * @RequestParam: double lat, double lng
     * @return A ResponseEntity contains the nearby store.
     */
	@RequestMapping(value = "v1/search", method = RequestMethod.GET)
	public ResponseEntity<Shop> searchShopByLatLng(@RequestParam double lat, @RequestParam double lng) {
		logger.info("> Search Shop");
		
		Shop nearestShop = shopSearch.searchShopByLatLng(lat, lng);
		if(nearestShop == null) {
			nearestShop = new Shop();
			ShopAddress address = new ShopAddress();
			nearestShop.shopAddress = address;
		}
		
		return new ResponseEntity<Shop>(nearestShop, HttpStatus.OK);
	}
}
