package com.swiggy.allocator.util;

import com.swiggy.allocator.model.Location;

public class DistanceUtil {

	private static final double PI = 3.141592653589793;
	private static final double RADIUS = 6378.16;

	public static long getDistance(Location loc1, Location loc2) {
		long distanceBetweenPlaces = (long) distanceBetweenPlaces(loc1.getLongitude(), loc1.getLatitude(), loc2.getLongitude(),
				loc2.getLatitude());
		System.out.println(distanceBetweenPlaces);
		System.out.println(loc1);
		System.out.println(loc2);
		return distanceBetweenPlaces;
	}

	private static double distanceBetweenPlaces(double lon1, double lat1, double lon2, double lat2) {
		double dlon = Radians(lon2 - lon1);
		double dlat = Radians(lat2 - lat1);

		double a = (Math.sin(dlat / 2) * Math.sin(dlat / 2))
				+ Math.cos(Radians(lat1)) * Math.cos(Radians(lat2)) * (Math.sin(dlon / 2) * Math.sin(dlon / 2));
		double angle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return angle * RADIUS;
	}

	public static double Radians(double x) {
		return x * PI / 180;
	}
}
