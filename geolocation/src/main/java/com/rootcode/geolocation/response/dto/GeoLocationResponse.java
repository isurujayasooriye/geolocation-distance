package com.rootcode.geolocation.response.dto;

public class GeoLocationResponse {

	private String city1;
	private String city2;
	private Double distanceInkillometers;

	public GeoLocationResponse(String city1, String city2, Double distanceInkillometers) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.distanceInkillometers = distanceInkillometers;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public Double getDistanceInkillometers() {
		return distanceInkillometers;
	}

	public void setDistanceInkillometers(Double distanceInkillometers) {
		this.distanceInkillometers = distanceInkillometers;
	}

}
