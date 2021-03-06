package com.gamma.air.repository;

import java.util.List;

import com.gamma.air.domain.Deal;
import com.gamma.air.domain.Flight;
import com.gamma.air.domain.Location;
import com.gamma.air.forms.Form;

public interface LocationDao {
	
  Location selectById(long id);

  List<Location> selectAll();

  Long insert(Location location);

  void update(Location location);

  void delete(Location location);
  
  List<Flight> selectFlights(Form form);
  
  Flight selectFlightById(Integer id);
  
  List<Deal> selectDeals(String code);
  
  List<Deal> selectDealById(List id);
}
