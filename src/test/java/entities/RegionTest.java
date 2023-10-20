package entities;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegionTest extends TestCase {

    public void testPolygonsAreReturned(){

        List<Double> point1 = new ArrayList<Double>(Arrays.asList(23.4335112530525,55.42757121786923));
        List<Double> point2 = new ArrayList<Double>(Arrays.asList(23.4335112530525,55.39275039575335));
        List<Double> point3 = new ArrayList<Double>(Arrays.asList(23.53866024454672,55.39275039575335));
        List<Double> point4 = new ArrayList<Double>(Arrays.asList(23.53866024454672,55.42757121786923));
        List<Double> point5 = new ArrayList<Double>(Arrays.asList(23.4335112530525,55.42757121786923));

        List<List<Double>> coordinates = new ArrayList<>();

        coordinates.add(point1);
        coordinates.add(point2);
        coordinates.add(point3);
        coordinates.add(point4);
        coordinates.add(point5);

        List<List<List<Double>>> polygons = new ArrayList<>();

        polygons.add(coordinates);

        Region region = new Region("RegionTest", polygons);

        assertEquals(RegionArea.class, region.getCoordinates().getClass());
    }

    public void testPolygonNameIsReturnedCorrectly(){
        List<Double> point1 = new ArrayList<Double>(Arrays.asList(23.4335112530525,55.42757121786923));
        List<Double> point2 = new ArrayList<Double>(Arrays.asList(23.4335112530525,55.39275039575335));
        List<Double> point3 = new ArrayList<Double>(Arrays.asList(23.53866024454672,55.39275039575335));
        List<Double> point4 = new ArrayList<Double>(Arrays.asList(23.53866024454672,55.42757121786923));
        List<Double> point5 = new ArrayList<Double>(Arrays.asList(23.4335112530525,55.42757121786923));

        List<List<Double>> coordinates = new ArrayList<>();

        coordinates.add(point1);
        coordinates.add(point2);
        coordinates.add(point3);
        coordinates.add(point4);
        coordinates.add(point5);

        List<List<List<Double>>> polygons = new ArrayList<>();

        polygons.add(coordinates);

        Region region = new Region("RegionTest", polygons);

        String checkString = "RegionTest";

        assertEquals(checkString, region.getName());
    }
}