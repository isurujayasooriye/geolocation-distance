package com.rootcode.geolocation.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rootcode.geolocation.exception.GeoLocationException;
import com.rootcode.geolocation.restclient.response.GoogleGeocode;

@Component
public class GeoLocationRestClient {

	@Autowired
	RestTemplate restTemplate;

	public String restClientForReversGeo(String restURL) throws GeoLocationException {
		GoogleGeocode googleGeocode = null;
		try {
			googleGeocode = restTemplate.getForObject(restURL, GoogleGeocode.class);
		} catch (Exception e) {
			throw new GeoLocationException("Service error");
		}

		if (googleGeocode.getResults().length == 0) {
			throw new GeoLocationException("Cannot find the location");
		}
		return googleGeocode.getResults()[0].getFormattedAddress();

	}

}
