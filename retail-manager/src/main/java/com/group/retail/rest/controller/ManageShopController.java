package com.group.retail.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group.retail.model.Shop;
import com.group.retail.services.AdminService;

/**
 * The ManageShopController class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>
 * which, by default, contains a ResponseEntity converted into JSON with an
 * associated HTTP status code.
 * 
 * @author Abhishek Verma
 */
@RestController
@RequestMapping(value = "/admin/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManageShopController extends BaseController {

	
	@Autowired
	private AdminService adminService;
	
	/**
     * Web service endpoint to create new Shop resource. The service returns
     * the status of the newly created resource as JSON.
     * @URI: /rms/admin/api/v1/create
     * @RequestBody: 
     * {  
   	 *		"shopName":"testShop",
   	 *		"shopAddress":{  
     *			"number":123456,
     * 			"postCode":411014
   	 *		}
	 *	}
     * @return A ResponseEntity contains the status of resource.
     */
	@RequestMapping(value = "v1/create", method = RequestMethod.POST)
	public ResponseEntity<String> createShopDetails(@Valid @RequestBody Shop body, BindingResult bindingResults) {
		logger.info("> Create Shop Details");
		
		boolean result = adminService.addShopAddress(body);
		
		if(!result) {
			return new ResponseEntity<String>("Resources Created Successfully.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Unable to create resource.", HttpStatus.OK);
		}
		
	}
}
