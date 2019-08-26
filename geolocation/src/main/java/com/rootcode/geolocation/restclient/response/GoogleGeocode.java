package com.rootcode.geolocation.restclient.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeocode {

	private GoogleGeocodeResult[] results;

	public GoogleGeocode() {
	}

	public GoogleGeocodeResult[] getResults() {
		return results;
	}

	public void setResults(GoogleGeocodeResult[] results) {
		this.results = results;
	}
}
