package io.github.anthonyrichir.jts.discretizer.util;

import ch.hsr.geohash.WGS84Point;
import org.locationtech.jts.geom.Coordinate;
import lombok.NonNull;

import java.util.function.Function;

/**
 * Created by anthonyrichir on 28/12/2016.
 */
public class WGS84Point2Coordinate implements Function<WGS84Point, Coordinate> {

	@Override
	public Coordinate apply(@NonNull WGS84Point wgs84Point) {
		return new Coordinate(wgs84Point.getLongitude(), wgs84Point.getLatitude());
	}
}
