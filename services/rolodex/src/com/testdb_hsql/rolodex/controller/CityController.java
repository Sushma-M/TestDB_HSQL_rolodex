/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.testdb_hsql.rolodex.service.AddressService;
import com.testdb_hsql.rolodex.service.CityService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.*;
import com.testdb_hsql.rolodex.*;
import com.testdb_hsql.rolodex.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class City.
 * @see com.testdb_hsql.rolodex.City
 */
@RestController(value = "Rolodex.CityController")
@RequestMapping("/rolodex/City")
@Api(description = "Exposes APIs to work with City resource.", value = "CityController")
public class CityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    @Qualifier("rolodex.CityService")
    private CityService cityService;

    @Autowired
    @Qualifier("rolodex.AddressService")
    private AddressService addressService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of City instances matching the search criteria.")
    public Page<City> findCitys(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Citys list");
        return cityService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of City instances.")
    public Page<City> getCitys(Pageable pageable) {
        LOGGER.debug("Rendering Citys list");
        return cityService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/addresses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the addresses instance associated with the given id.")
    public Page<Address> findAssociatedaddresses(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated addresses");
        return addressService.findAssociatedValues(id, "city", "cityId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setCityService(CityService service) {
        this.cityService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new City instance.")
    public City createCity(@RequestBody City instance) {
        LOGGER.debug("Create City with information: {}", instance);
        instance = cityService.create(instance);
        LOGGER.debug("Created City with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of City instances.")
    public Long countAllCitys() {
        LOGGER.debug("counting Citys");
        Long count = cityService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the City instance associated with the given id.")
    public City getCity(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting City with id: {}", id);
        City instance = cityService.findById(id);
        LOGGER.debug("City details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the City instance associated with the given id.")
    public City editCity(@PathVariable(value = "id") Integer id, @RequestBody City instance) throws EntityNotFoundException {
        LOGGER.debug("Editing City with id: {}", instance.getCityId());
        instance.setCityId(id);
        instance = cityService.update(instance);
        LOGGER.debug("City details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the City instance associated with the given id.")
    public boolean deleteCity(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting City with id: {}", id);
        City deleted = cityService.delete(id);
        return deleted != null;
    }
}
