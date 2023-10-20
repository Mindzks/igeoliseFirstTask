package entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public final class Region {
    private final String name;
    private final RegionArea coordinates;

    @JsonCreator
    public Region(@JsonProperty("name")String name,@JsonProperty("coordinates") List<List<List<Double>>> coordinates) {
        this.name = name;
        List<Polygon> tempListOfPolygon = new ArrayList<>();
        for (List<List<Double>> area: coordinates){
            List<Coordinates> tempPolygon = new ArrayList<>();
            for (List<Double> coordinate: area){
                tempPolygon.add(new Coordinates(coordinate.get(0), coordinate.get(1)));
            }
            tempListOfPolygon.add(new Polygon(tempPolygon));
        }
        this.coordinates = new RegionArea(tempListOfPolygon);
    }

    public String getName() {
        String currentName = new String(this.name);
        return currentName;
    }

    /**
     * RegionArea coordinates is a list of polygons
     * */
    public RegionArea getCoordinates() {
        //creating tempList for saving polygons which I'm getting in for cycle
        List<Polygon> tempList = new ArrayList<>();
        //Going through each polygon in the region
        for (Polygon polygon: coordinates.getArea()){
            //creating temporary polygon instance
            Polygon tempPolygon = new Polygon(polygon.getPolygonArea());
            //adding that instance to temporary list
            tempList.add(tempPolygon);
        }
        //adding all polygons to the region
        RegionArea currentCoordinates = new RegionArea(tempList);
        return currentCoordinates;
    }

}
