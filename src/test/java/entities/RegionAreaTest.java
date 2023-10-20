package entities;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegionAreaTest extends TestCase {
    public void testPolygonsAreReturned(){

        Coordinates point1 = new Coordinates(23.4335112530525,55.42757121786923);
        Coordinates point2 = new Coordinates(23.4335112530525,55.39275039575335);
        Coordinates point3 = new Coordinates(23.53866024454672,55.39275039575335);
        Coordinates point4 = new Coordinates(23.53866024454672,55.42757121786923);
        Coordinates point5 = new Coordinates(23.4335112530525,55.42757121786923);

        List<Coordinates> polygonCoordinates = new ArrayList<>();
        polygonCoordinates.add(point1);
        polygonCoordinates.add(point2);
        polygonCoordinates.add(point3);
        polygonCoordinates.add(point4);
        polygonCoordinates.add(point5);

        Polygon polygon = new Polygon(polygonCoordinates);

        List<Polygon> polygons = new ArrayList<>();

        polygons.add(polygon);

        RegionArea regionArea = new RegionArea(polygons);

        assertEquals(polygons.getClass(), regionArea.getArea().getClass());
    }

    public void testThereAreTwoPolygonsInArea(){

        Coordinates point1 = new Coordinates(23.4335112530525,55.42757121786923);
        Coordinates point2 = new Coordinates(23.4335112530525,55.39275039575335);
        Coordinates point3 = new Coordinates(23.53866024454672,55.39275039575335);
        Coordinates point4 = new Coordinates(23.53866024454672,55.42757121786923);
        Coordinates point5 = new Coordinates(23.4335112530525,55.42757121786923);

        List<Coordinates> polygonCoordinates = new ArrayList<>();
        polygonCoordinates.add(point1);
        polygonCoordinates.add(point2);
        polygonCoordinates.add(point3);
        polygonCoordinates.add(point4);
        polygonCoordinates.add(point5);

        Polygon polygon1 = new Polygon(polygonCoordinates);
        Polygon polygon2 = new Polygon(polygonCoordinates);

        List<Polygon> polygons = new ArrayList<>();

        polygons.add(polygon1);
        polygons.add(polygon2);

        RegionArea regionArea = new RegionArea(polygons);

        assertEquals(2, regionArea.getSize());
    }
}