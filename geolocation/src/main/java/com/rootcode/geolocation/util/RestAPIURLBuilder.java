package com.rootcode.geolocation.util;

import org.springframework.stereotype.Component;

import com.rootcode.geolocation.request.dto.LocationMetrix;

@Component
public class RestAPIURLBuilder {

	public String buildGeoLocationRESTURL(String endpoint, String googleKey, LocationMetrix metrix) {
		return endpoint + "?latlng=" + metrix.getLatitude() + "," + metrix.getLongitude() + "&key=" + googleKey;
	}

}
