package com.gamma.air.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamma.air.domain.Deal;
import com.gamma.air.domain.Flight;
import com.gamma.air.domain.Location;
import com.gamma.air.forms.Form;
import com.gamma.air.repository.LocationDao;
import com.gamma.air.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
  
  private Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);	

  @Autowired
  private LocationDao locationDao;
  
  public List<Location> selectAll() {
    return locationDao.selectAll();
  }

  public Long insert(Location location) {
    return locationDao.insert(location);
  }

  public void update(Location location) {
	  locationDao.update(location);
  }

  public void delete(Location location) {
	  locationDao.delete(location);
  }

  public Location selectById(long id) {
    return locationDao.selectById(id);
  }
  
  public List<Flight> selectFlights(Form form) {
	return locationDao.selectFlights(form);
  }
  
  public Flight selectFlightById(Integer id) {
	return locationDao.selectFlightById(id);
  }

  public List<Deal> selectDeals(String code) {
	return locationDao.selectDeals(code);
  }
  
  public List<Deal> selectDealById(Integer[] ids) {	
	if (ids==null) 
		ids = new Integer[] {0};			
	
	return locationDao.selectDealById(Arrays.asList(ids));
  }
}
