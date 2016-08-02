/*Generated by WaveMaker Studio*/

package com.testdb_hsql.rolodex.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.testdb_hsql.rolodex.*;

/**
 * Service object for domain model class City.
 * @see com.testdb_hsql.rolodex.City
 */

public interface CityService {
   /**
	 * Creates a new city.
	 * 
	 * @param created
	 *            The information of the created city.
	 * @return The created city.
	 */
	public City create(City created);

	/**
	 * Deletes a city.
	 * 
	 * @param cityId
	 *            The id of the deleted city.
	 * @return The deleted city.
	 * @throws EntityNotFoundException
	 *             if no city is found with the given id.
	 */
	public City delete(Integer cityId) throws EntityNotFoundException;

	/**
	 * Finds all citys.
	 * 
	 * @return A list of citys.
	 */
	public Page<City> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<City> findAll(Pageable pageable);
	
	/**
	 * Finds city by id.
	 * 
	 * @param id
	 *            The id of the wanted city.
	 * @return The found city. If no city is found, this method returns
	 *         null.
	 */
	public City findById(Integer id) throws EntityNotFoundException;
	/**
	 * Updates the information of a city.
	 * 
	 * @param updated
	 *            The information of the updated city.
	 * @return The updated city.
	 * @throws EntityNotFoundException
	 *             if no city is found with given id.
	 */
	public City update(City updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the citys in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the city.
	 */

	public long countAll();


    public Page<City> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

