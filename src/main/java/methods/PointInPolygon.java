package methods;

import entities.Coordinates;
import entities.Polygon;

import java.util.List;

public class PointInPolygon {
    //Algorythm I have used: https://www.algorithms-and-technologies.com/point_in_polygon/java
    public static boolean PIP(Polygon polygon, Coordinates point) throws Exception {
        boolean odd = false;
        // For each edge (In this case for each point of the polygon and the previous one)
        for (int i = 0, j = polygon.size() - 1; i < polygon.size(); i++) {
            //Check if its polygon
            if(ValidPolygonCheck(polygon)){
                //here we get vertice
                Coordinates polyPoint1 = polygon.get(i);
                Coordinates polyPoint2 = polygon.get(j);

                if(!ValidCoordinatesCheck(point)){
                    throw new Exception("Given location point is not valid");
                }

                //here we get vertice coordinates
                double x1 = polyPoint1.getLongitude();
                double y1 = polyPoint1.getLatitude();
                double x2 = polyPoint2.getLongitude();
                double y2 = polyPoint2.getLatitude();

                //Here we get location coordinates
                double x = point.getLongitude();
                double y = point.getLatitude();

                // If a line from the point into infinity crosses this edge
                if (((y1 > y) != (y2 > y)) &&
                        (x < (x2 - x1) * (y - y1) / (y2 - y1) + x1)) {
                    odd = !odd;
                }

                j = i;
            }else{
                throw new Exception("Given not valid polygon");
            }
        }
        return odd;
    }

    /**
     * Valid polygon should contain at least 4 points where first and last point are the same.
     * */
    public static boolean ValidPolygonCheck(Polygon polygon){
        boolean ValidCheck = false;
        //check how many points are in the polygon and if first coordinate matches last coordinate
        if(polygon.size() >= 4 && polygon.get(0).getLongitude() == polygon.get(polygon.size()-1).getLongitude() && polygon.get(0).getLatitude() == polygon.get(polygon.size()-1).getLatitude() ){
            for (Coordinates coordinate: polygon.getPolygonArea()){
                if(!ValidCoordinatesCheck(coordinate)){
                    return ValidCheck;
                }
            }
            ValidCheck = true;
            return ValidCheck;
        }
        return ValidCheck;
    }

    public static boolean ValidCoordinatesCheck(Coordinates coordinates){
        boolean ValidCheck = false;

        if( coordinates.getLatitude()>-90 && coordinates.getLatitude()< 90 && coordinates.getLongitude()>-180 && coordinates.getLongitude()<180){
            ValidCheck = true;
            return ValidCheck;
        }
        return ValidCheck;
    }

}