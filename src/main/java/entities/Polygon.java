package entities;

import java.util.ArrayList;
import java.util.List;

public final class Polygon {
    private final List<Coordinates> polygonArea;
    public Polygon(List<Coordinates> polygonArea) {
        this.polygonArea = polygonArea;
    }

    public int size(){
        int PolygonAreaSize = new Integer(polygonArea.size());
        return PolygonAreaSize;
    }

    public Coordinates get(int i){
        if(polygonArea.get(i) == null){
            throw new IllegalStateException("Theres no data about the polygon. Index out of bounds.");
        }else{
            Coordinates currentCoordinates = new Coordinates(polygonArea.get(i).getLongitude(), polygonArea.get(i).getLatitude());
            return currentCoordinates;
        }
    }

    public List<Coordinates> getPolygonArea() {
        List<Coordinates> currentPolygonArea = new ArrayList<Coordinates>();
        for (Coordinates coordinate:this.polygonArea){
            currentPolygonArea.add(coordinate);
        }
        return currentPolygonArea;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "polygonArea=" + polygonArea +
                '}';
    }
}
