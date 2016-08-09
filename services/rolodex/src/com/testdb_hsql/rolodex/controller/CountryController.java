/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.testdb_hsql.rolodex.service.CityService;
import com.testdb_hsql.rolodex.service.CountryService;
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
 * Controller object for domain model class Country.
 * @see com.testdb_hsql.rolodex.Country
 */
@RestController(value = "Rolodex.CountryController")
@RequestMapping("/rolodex/Country")
@Api(description = "Exposes APIs to work with Country resource.", value = "CountryController")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    @Qualifier("rolodex.CountryService")
    private CountryService countryService;

    @Autowired
    @Qualifier("rolodex.CityService")
    private CityService cityService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Country instances matching the search criteria.")
    public Page<Country> findCountrys(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Countrys list");
        return countryService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Country instances.")
    public Page<Country> getCountrys(Pageable pageable) {
        LOGGER.debug("Rendering Countrys list");
        return countryService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/cities", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the cities instance associated with the given id.")
    public Page<City> findAssociatedcities(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated cities");
        return cityService.findAssociatedValues(id, "country", "countryId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setCountryService(CountryService service) {
        this.countryService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Country instance.")
    public Country createCountry(@RequestBody Country instance) {
        LOGGER.debug("Create Country with information: {}", instance);
        instance = countryService.create(instance);
        LOGGER.debug("Created Country with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Country instances.")
    public Long countAllCountrys() {
        LOGGER.debug("counting Countrys");
        Long count = countryService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Country instance associated with the given id.")
    public Country getCountry(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Country with id: {}", id);
        Country instance = countryService.findById(id);
        LOGGER.debug("Country details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Country instance associated with the given id.")
    public Country editCountry(@PathVariable(value = "id") Integer id, @RequestBody Country instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Country with id: {}", instance.getCountryId());
        instance.setCountryId(id);
        instance = countryService.update(instance);
        LOGGER.debug("Country details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Country instance associated with the given id.")
    public boolean deleteCountry(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Country with id: {}", id);
        Country deleted = countryService.delete(id);
        return deleted != null;
    }
}
