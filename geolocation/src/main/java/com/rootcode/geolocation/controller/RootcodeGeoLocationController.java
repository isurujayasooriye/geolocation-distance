package com.rootcode.geolocation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootcode.geolocation.exception.GeoLocationException;
import com.rootcode.geolocation.request.dto.GeoLocationRequest;
import com.rootcode.geolocation.request.dto.LocationMetrix;
import com.rootcode.geolocation.response.dto.GeoLocationResponse;
import com.rootcode.geolocation.service.IGeoLocationService;

@RestController
@RequestMapping("/rootcode-geo")
public class RootcodeGeoLocationController {
	
	@Autowired
	IGeoLocationService geoLocationService;
	
	@PostMapping("/find-location")
	public String findLocationName(@RequestBody LocationMetrix request) throws GeoLocationException {
		return geoLocationService.getGeoDetails(request);
		
	}
	
	@PostMapping("/find-locations-and-distance")
	public GeoLocationResponse findLocationNamesAndDistance(@RequestBody GeoLocationRequest request) throws GeoLocationException {
		return geoLocationService.getLocationsAndDistance(request);
		
	}

}
