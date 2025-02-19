package io.github.anthonyrichir.jts.discretizer.geometry;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import org.locationtech.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTWriter;
import io.github.anthonyrichir.jts.discretizer.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

/**
 * Created by anthonyrichir on 28/12/2016.
 */
class LineStringDiscretizerTest extends GeometryDiscretizerTestBase {

	private LineStringDiscretizer discretizer;

	@BeforeEach
	void setUp() {
		final Coordinate2WGS84Point coordinate2WGS84Point = new Coordinate2WGS84Point();
		final CoordinateDiscretizer coordinateDiscretizer = new CoordinateDiscretizer(coordinate2WGS84Point);
		final GeoHash2Geometry geoHash2Geometry = new GeoHash2Geometry(this.wgs84Point2Coordinate);
		final SegmentDiscretizer segmentDiscretizer = new SegmentDiscretizer(coordinateDiscretizer, geoHash2Geometry);
		this.discretizer = new LineStringDiscretizer(segmentDiscretizer);
	}

	@Test
	void discretizeNull() {
		assertThrows(IllegalArgumentException.class, () -> this.discretizer.apply(mock(LineString.class), null));
		assertThrows(IllegalArgumentException.class, () -> this.discretizer.apply(null, 2));

	}

	@Test
	void discretizeEmptyLineString() {
		final LineString lineString = this.geometryFactory.createLineString(new Coordinate[] {});
		assertThrows(IllegalArgumentException.class, () -> this.discretizer.apply(lineString, 4));
	}

	@Test
	void discretize() throws ParseException {
		final LineString lineString = lineString123456();
		final Set<GeoHash> geoHashes = this.discretizer.apply(lineString, 4);
		// printDebugWKT(lineString, geoHashes);

		final Set<GeoHash> expected = discretized123456();

		assertEquals(expected, geoHashes);
	}
}