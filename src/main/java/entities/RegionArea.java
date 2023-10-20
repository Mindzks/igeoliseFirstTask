package entities;

import java.util.ArrayList;
import java.util.List;

public final class RegionArea {
    private final List<Polygon> polygons;

    public RegionArea(List<Polygon> area) {
        this.polygons = area;
    }

    public List<Polygon> getArea() {
        List<Polygon> currentPolygons = new ArrayList<>();
        for (Polygon polygon: this.polygons){
            List<Coordinates> tempCoordinatesList = new ArrayList<>();
            for (Coordinates coordinate: polygon.getPolygonArea()){
                Coordinates tempCoordinate = new Coordinates(coordinate.getLongitude(),coordinate.getLatitude());
                tempCoordinatesList.add(tempCoordinate);
            }
            Polygon tempPolygon = new Polygon(tempCoordinatesList);
            currentPolygons.add(tempPolygon);
        }
        return currentPolygons;
    }

    public int getSize(){
        int currentSize = new Integer(polygons.size());
        return currentSize;
    }

    @Override
    public String toString() {
        return "RegionArea{" +
                "Polygons=" + polygons +
                '}';
    }
}
