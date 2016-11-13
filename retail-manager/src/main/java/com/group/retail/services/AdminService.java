package com.group.retail.services;

import com.group.retail.model.Shop;

/**
 * The AdminService interface defines all public business behaviors for
 * operations on the Retail Management.
 * 
 * This interface should be injected into AdminService clients, not the
 * implementation bean.
 * 
 * @author Abhishek Verma
 */
public interface AdminService {

	/**
     * Persists a Shop entity in the data store.
     * @param user A Shop object to be persisted.
     * @return The boolean status.
     */
	boolean addShopAddress(Shop shop);
	
}
