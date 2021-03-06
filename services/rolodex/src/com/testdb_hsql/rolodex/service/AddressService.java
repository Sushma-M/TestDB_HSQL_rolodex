/*Generated by WaveMaker Studio*/

package com.testdb_hsql.rolodex.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.testdb_hsql.rolodex.*;

/**
 * Service object for domain model class Address.
 * @see com.testdb_hsql.rolodex.Address
 */

public interface AddressService {
   /**
	 * Creates a new address.
	 * 
	 * @param created
	 *            The information of the created address.
	 * @return The created address.
	 */
	public Address create(Address created);

	/**
	 * Deletes a address.
	 * 
	 * @param addressId
	 *            The id of the deleted address.
	 * @return The deleted address.
	 * @throws EntityNotFoundException
	 *             if no address is found with the given id.
	 */
	public Address delete(Integer addressId) throws EntityNotFoundException;

	/**
	 * Finds all addresss.
	 * 
	 * @return A list of addresss.
	 */
	public Page<Address> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Address> findAll(Pageable pageable);
	
	/**
	 * Finds address by id.
	 * 
	 * @param id
	 *            The id of the wanted address.
	 * @return The found address. If no address is found, this method returns
	 *         null.
	 */
	public Address findById(Integer id) throws EntityNotFoundException;
	/**
	 * Updates the information of a address.
	 * 
	 * @param updated
	 *            The information of the updated address.
	 * @return The updated address.
	 * @throws EntityNotFoundException
	 *             if no address is found with given id.
	 */
	public Address update(Address updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the addresss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the address.
	 */

	public long countAll();


    public Page<Address> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

