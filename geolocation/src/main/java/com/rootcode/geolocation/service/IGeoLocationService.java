package com.rootcode.geolocation.service;

import com.rootcode.geolocation.exception.GeoLocationException;
import com.rootcode.geolocation.request.dto.GeoLocationRequest;
import com.rootcode.geolocation.request.dto.LocationMetrix;
import com.rootcode.geolocation.response.dto.GeoLocationResponse;

public interface IGeoLocationService {

	String getGeoDetails(LocationMetrix metrix) throws GeoLocationException;

	GeoLocationResponse getLocationsAndDistance(GeoLocationRequest metrix) throws GeoLocationException;

}
