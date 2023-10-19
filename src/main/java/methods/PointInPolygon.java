package methods;

import java.util.List;

public class PointInPolygon {
    //Algorythm I have used: https://www.algorithms-and-technologies.com/point_in_polygon/java
    public static boolean PIP(List<List<Double>> polygon, List<Double> point){
        boolean odd = false;
// For each edge (In this case for each point of the polygon and the previous one)
        for (int i = 0, j = polygon.size() - 1; i < polygon.size(); i++) {
            List<Double> polyPoint1 = polygon.get(i);
            List<Double> polyPoint2 = polygon.get(j);

            double x1 = polyPoint1.get(0);
            double y1 = polyPoint1.get(1);
            double x2 = polyPoint2.get(0);
            double y2 = polyPoint2.get(1);

            double x = point.get(0);
            double y = point.get(1);

            // If a line from the point into infinity crosses this edge
            if (((y1 > y) != (y2 > y)) &&
                    (x < (x2 - x1) * (y - y1) / (y2 - y1) + x1)) {
                odd = !odd;
            }

            j = i;
        }

        return odd;
    }
}