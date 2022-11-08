package io.github.anthonyrichir.jts.discretizer.util;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import org.locationtech.jts.geom.Coordinate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by anthonyrichir on 26/12/2016.
 */
@RequiredArgsConstructor
public class CoordinateDiscretizer implements BiFunction<Coordinate, Integer, GeoHash> {

	private final Function<Coordinate, WGS84Point> coordinate2WGS84Point;

	public GeoHash apply(@NonNull Coordinate coordinate, @NonNull Integer precision) {
		final WGS84Point point = this.coordinate2WGS84Point.apply(coordinate);
		return GeoHash.withCharacterPrecision(point.getLatitude(), point.getLongitude(), precision);
	}
}
