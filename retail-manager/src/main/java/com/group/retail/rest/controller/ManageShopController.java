package com.group.retail.rest.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The DirectoryController class is a RESTful web service controller. The
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

	
	/**
     * Web service endpoint to create new Shop resource. The service returns
     * the status of the newly created resource as JSON.
     * @URI: /admin/api/v1/create
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
	public ResponseEntity<String> createShopDetails(@Valid @RequestBody String body) {
		
		logger.info("> Create Shop Details");
		
		return new ResponseEntity<String>("Resources Created Successfully.", HttpStatus.CREATED);
	}
}
