package com.rootcode.geolocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rootcode.geolocation.exception.GeoLocationException;
import com.rootcode.geolocation.request.dto.GeoLocationRequest;
import com.rootcode.geolocation.request.dto.LocationMetrix;
import com.rootcode.geolocation.response.dto.GeoLocationResponse;
import com.rootcode.geolocation.restclient.GeoLocationRestClient;
import com.rootcode.geolocation.util.DistanceFinder;
import com.rootcode.geolocation.util.RestAPIURLBuilder;

@Service
public class GeoLocationServiceImpl implements IGeoLocationService {

	@Autowired
	private GeoLocationRestClient geoLocationRestClient;

	@Autowired
	private DistanceFinder distanceFinder;

	@Autowired
	private RestAPIURLBuilder restAPIURLBuilder;

	@Value("${google.map.rest.api.endpoint}")
	private String GOOGLE_MAP_REST_API_ENDPOINT;

	@Value("${google.map.key}")
	private String GOOGLE_MAP_KEY;

	@Override
	public String getGeoDetails(LocationMetrix metrix) throws GeoLocationException {
		// TODO Auto-generated method stub
		return geoLocationRestClient.restClientForReversGeo(
				restAPIURLBuilder.buildGeoLocationRESTURL(GOOGLE_MAP_REST_API_ENDPOINT, GOOGLE_MAP_KEY, metrix));
	}

	@Override
	public GeoLocationResponse getLocationsAndDistance(GeoLocationRequest metrix) throws GeoLocationException {

		String city1 = geoLocationRestClient.restClientForReversGeo(restAPIURLBuilder
				.buildGeoLocationRESTURL(GOOGLE_MAP_REST_API_ENDPOINT, GOOGLE_MAP_KEY, metrix.getLocation1()));
		String city2 = geoLocationRestClient.restClientForReversGeo(restAPIURLBuilder
				.buildGeoLocationRESTURL(GOOGLE_MAP_REST_API_ENDPOINT, GOOGLE_MAP_KEY, metrix.getLocation2()));

		double distance = distanceFinder.findDistance(metrix.getLocation1(), metrix.getLocation2());

		// TODO Auto-generated method stub
		return new GeoLocationResponse(city1, city2, distance);
	}

}
