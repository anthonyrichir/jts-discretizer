package io.github.anthonyrichir.jts.discretizer.util;

import ch.hsr.geohash.WGS84Point;
import org.locationtech.jts.geom.Coordinate;
import lombok.NonNull;

import java.util.function.Function;

/**
 * Created by anthonyrichir on 28/12/2016.
 */
public class Coordinate2WGS84Point implements Function<Coordinate, WGS84Point> {

	@Override
	public WGS84Point apply(@NonNull Coordinate coordinate) {
		return new WGS84Point(coordinate.y, coordinate.x);
	}
}
