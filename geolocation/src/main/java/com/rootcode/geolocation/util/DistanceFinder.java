package com.rootcode.geolocation.util;

import org.springframework.stereotype.Component;

import com.rootcode.geolocation.exception.GeoLocationException;
import com.rootcode.geolocation.request.dto.LocationMetrix;

@Component
public class DistanceFinder {

	final double DISTANCE_BETWEEN_LATITUDE_DEGREE = 111;
	final double DISTANCE_BETWEEN_LONGITUDE_DEGREE = 111.321;

	public Double findDistance(LocationMetrix locationMetrix1, LocationMetrix locationMetrix2)
			throws GeoLocationException {
		double distance = 0d;
		try {
			double latitudeDiff = Double.parseDouble(locationMetrix1.getLatitude())
					- Double.parseDouble(locationMetrix2.getLatitude());
			double longitudeDiff = Double.parseDouble(locationMetrix1.getLongitude())
					- Double.parseDouble(locationMetrix2.getLongitude());

			distance = Math.sqrt(Math.pow((latitudeDiff * DISTANCE_BETWEEN_LATITUDE_DEGREE), 2)
					+ Math.pow((longitudeDiff * DISTANCE_BETWEEN_LONGITUDE_DEGREE), 2));
			return distance;
		} catch (Exception e) {
			throw new GeoLocationException("Error on finding the distance");
		}

	}
}
