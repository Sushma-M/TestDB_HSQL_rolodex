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
 * ServiceImpl object for domain model class Inventory.
 * @see com.testdb_hsql.rolodex.Inventory
 */
@Service("rolodex.InventoryService")
public class InventoryServiceImpl implements InventoryService {


    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    @Qualifier("rolodex.InventoryDao")
    private WMGenericDao<Inventory, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Inventory, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "rolodexTransactionManager")
     public Page<Inventory> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "rolodexTransactionManager")
    @Override
    public Inventory create(Inventory inventory) {
        LOGGER.debug("Creating a new inventory with information: {}" , inventory);
        return this.wmGenericDao.create(inventory);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "rolodexTransactionManager")
    @Override
    public Inventory delete(Integer inventoryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting inventory with id: {}" , inventoryId);
        Inventory deleted = this.wmGenericDao.findById(inventoryId);
        if (deleted == null) {
            LOGGER.debug("No inventory found with id: {}" , inventoryId);
            throw new EntityNotFoundException(String.valueOf(inventoryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Page<Inventory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all inventorys");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Page<Inventory> findAll(Pageable pageable) {
        LOGGER.debug("Finding all inventorys");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Inventory findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding inventory by id: {}" , id);
        Inventory inventory=this.wmGenericDao.findById(id);
        if(inventory==null){
            LOGGER.debug("No inventory found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return inventory;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "rolodexTransactionManager")
    @Override
    public Inventory update(Inventory updated) throws EntityNotFoundException {
        LOGGER.debug("Updating inventory with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getInventoryId());
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


