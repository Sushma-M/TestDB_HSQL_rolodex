/*Generated by WaveMaker Studio*/

package com.testdb_hsql.rolodex.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.testdb_hsql.rolodex.*;


/**
 * ServiceImpl object for domain model class Store.
 * @see com.testdb_hsql.rolodex.Store
 */
@Service("rolodex.StoreService")
public class StoreServiceImpl implements StoreService {


    private static final Logger LOGGER = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    @Qualifier("rolodex.StoreDao")
    private WMGenericDao<Store, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Store, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "rolodexTransactionManager")
     public Page<Store> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "rolodexTransactionManager")
    @Override
    public Store create(Store store) {
        LOGGER.debug("Creating a new store with information: {}" , store);
        return this.wmGenericDao.create(store);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "rolodexTransactionManager")
    @Override
    public Store delete(Integer storeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting store with id: {}" , storeId);
        Store deleted = this.wmGenericDao.findById(storeId);
        if (deleted == null) {
            LOGGER.debug("No store found with id: {}" , storeId);
            throw new EntityNotFoundException(String.valueOf(storeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Page<Store> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all stores");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Page<Store> findAll(Pageable pageable) {
        LOGGER.debug("Finding all stores");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Store findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding store by id: {}" , id);
        Store store=this.wmGenericDao.findById(id);
        if(store==null){
            LOGGER.debug("No store found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return store;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "rolodexTransactionManager")
    @Override
    public Store update(Store updated) throws EntityNotFoundException {
        LOGGER.debug("Updating store with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getStoreId());
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

