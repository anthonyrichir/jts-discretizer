package io.github.anthonyrichir.jts.discretizer.geometry;

import ch.hsr.geohash.GeoHash;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;
import io.github.anthonyrichir.jts.discretizer.GeometryDiscretizer;
import io.github.anthonyrichir.jts.discretizer.util.CoordinateDiscretizer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * Created by anthonyrichir on 26/12/2016.
 */
@RequiredArgsConstructor
public class PointDiscretizer implements GeometryDiscretizer<Point> {

	private final BiFunction<Coordinate, Integer, GeoHash> coordinateDiscretizer;

	@Override
	public Set<GeoHash> apply(@NonNull Point geometry, @NonNull Integer precision) {
		return Stream.of(this.coordinateDiscretizer.apply(geometry.getCoordinate(), precision))
				.collect(toSet());
	}
}
