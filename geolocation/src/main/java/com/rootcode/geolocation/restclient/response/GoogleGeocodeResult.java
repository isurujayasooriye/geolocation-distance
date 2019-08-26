package com.rootcode.geolocation.restclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleGeocodeResult {

	@JsonProperty("formatted_address")
	private String formattedAddress;

	public GoogleGeocodeResult() {
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
}
