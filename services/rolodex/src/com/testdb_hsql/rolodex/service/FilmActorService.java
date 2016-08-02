/*Generated by WaveMaker Studio*/

package com.testdb_hsql.rolodex.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.testdb_hsql.rolodex.*;

/**
 * Service object for domain model class FilmActor.
 * @see com.testdb_hsql.rolodex.FilmActor
 */

public interface FilmActorService {
   /**
	 * Creates a new filmactor.
	 * 
	 * @param created
	 *            The information of the created filmactor.
	 * @return The created filmactor.
	 */
	public FilmActor create(FilmActor created);

	/**
	 * Deletes a filmactor.
	 * 
	 * @param filmactorId
	 *            The id of the deleted filmactor.
	 * @return The deleted filmactor.
	 * @throws EntityNotFoundException
	 *             if no filmactor is found with the given id.
	 */
	public FilmActor delete(FilmActorId filmactorId) throws EntityNotFoundException;

	/**
	 * Finds all filmactors.
	 * 
	 * @return A list of filmactors.
	 */
	public Page<FilmActor> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<FilmActor> findAll(Pageable pageable);
	
	/**
	 * Finds filmactor by id.
	 * 
	 * @param id
	 *            The id of the wanted filmactor.
	 * @return The found filmactor. If no filmactor is found, this method returns
	 *         null.
	 */
	public FilmActor findById(FilmActorId id) throws EntityNotFoundException;
	/**
	 * Updates the information of a filmactor.
	 * 
	 * @param updated
	 *            The information of the updated filmactor.
	 * @return The updated filmactor.
	 * @throws EntityNotFoundException
	 *             if no filmactor is found with given id.
	 */
	public FilmActor update(FilmActor updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the filmactors in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the filmactor.
	 */

	public long countAll();


    public Page<FilmActor> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
