package io.github.anthonyrichir.jts.discretizer;

import com.vividsolutions.jts.geom.*;

/**
 * Created by anthonyrichir on 30/12/2016.
 */
public interface DiscretizerFactory {

	<T extends Geometry> GeometryDiscretizer<T> discretizer(T geometry);

	GeometryDiscretizer<GeometryCollection> geometryCollectionDiscretizer();

	GeometryDiscretizer<LineString> lineStringDiscretizer();

	GeometryDiscretizer<Polygon> polygonDiscretizer();

	GeometryDiscretizer<Point> pointDiscretizer();
}
