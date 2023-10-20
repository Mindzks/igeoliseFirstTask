package methods;

import entities.Coordinates;
import entities.Polygon;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static methods.PointInPolygon.*;
import static org.junit.Assert.assertThrows;

public class PointInPolygonTest extends TestCase {

    @Test
    public void testValidCoordinateWasPassed(){

        double longitude = 12.123213;
        double latitude = 56.1515151;

        Coordinates coordinates = new Coordinates(longitude,latitude);

        assertTrue(ValidCoordinatesCheck(coordinates));

    }
    @Test
    public void testNotValidCoordinateWasPassed(){

        double longitude = 190.123213;
        double latitude = -80.1515151;

        Coordinates coordinates = new Coordinates(longitude,latitude);

        assertFalse(ValidCoordinatesCheck(coordinates));
    }
    @Test
    public void testValidPolygonWasPassed(){

        double longitude1 = 21.099044587495996;
        double latitude1 = 55.697364539462455;
        double longitude2 = 21.13167699979246;
        double latitude2 = 55.63985211052827;
        double longitude3 = 21.233653288216374;
        double latitude3 =  55.6766698024725;
        double longitude4 = 21.099044587495996;
        double latitude4 = 55.697364539462455;


        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude1,latitude1));
        coordinates.add(new Coordinates(longitude2,latitude2));
        coordinates.add(new Coordinates(longitude3,latitude3));
        coordinates.add(new Coordinates(longitude4,latitude4));

        Polygon polygon = new Polygon(coordinates);

        assertTrue(ValidPolygonCheck(polygon));

    }
    @Test
    public void testPolygonWithLessThanFourPointsWasPassed(){

        double longitude1 = 21.099044587495996;
        double latitude1 = 55.697364539462455;
        double longitude2 = 21.13167699979246;
        double latitude2 = 55.63985211052827;
        double longitude3 = 21.099044587495996;
        double latitude3 = 55.697364539462455;


        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude1,latitude1));
        coordinates.add(new Coordinates(longitude2,latitude2));
        coordinates.add(new Coordinates(longitude3,latitude3));

        Polygon polygon = new Polygon(coordinates);

        assertFalse(ValidPolygonCheck(polygon));

    }
    @Test
    public void testPolygonWithInvalidCoordinatesWasPassed(){

        double longitude1 = 1221.099044587495996;
        double latitude1 = 55.697364539462455;
        double longitude2 = 21.13167699979246;
        double latitude2 = 55.63985211052827;
        double longitude3 = 21.233653288216374;
        double latitude3 =  55.6766698024725;
        double longitude4 = 21.099044587495996;
        double latitude4 = 55.697364539462455;


        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude1,latitude1));
        coordinates.add(new Coordinates(longitude2,latitude2));
        coordinates.add(new Coordinates(longitude3,latitude3));
        coordinates.add(new Coordinates(longitude4,latitude4));

        Polygon polygon = new Polygon(coordinates);

        assertFalse(ValidPolygonCheck(polygon));

    }
    @Test
    public void testGivenPointIsInsidePolygon(){
        double longitude1 = 23.4335112530525;
        double latitude1 = 55.42757121786923;
        double longitude2 = 23.4335112530525;
        double latitude2 = 55.39275039575335;
        double longitude3 = 23.53866024454672;
        double latitude3 =  55.39275039575335;
        double longitude4 = 23.53866024454672;
        double latitude4 = 55.42757121786923;
        double longitude5 = 23.4335112530525;
        double latitude5 = 55.42757121786923;

        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude1,latitude1));
        coordinates.add(new Coordinates(longitude2,latitude2));
        coordinates.add(new Coordinates(longitude3,latitude3));
        coordinates.add(new Coordinates(longitude4,latitude4));
        coordinates.add(new Coordinates(longitude5,latitude5));

        double locationLongitude = 23.471789192627483;
        double locationLatitude = 55.41657847958601;

        Polygon polygon = new Polygon(coordinates);

        Coordinates location = new Coordinates(locationLongitude,locationLatitude);
        try{
            assertTrue(PIP(polygon, location));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testGivenPointIsOutsidePolygon(){
        double longitude1 = 23.4335112530525;
        double latitude1 = 55.42757121786923;
        double longitude2 = 23.4335112530525;
        double latitude2 = 55.39275039575335;
        double longitude3 = 23.53866024454672;
        double latitude3 =  55.39275039575335;
        double longitude4 = 23.53866024454672;
        double latitude4 = 55.42757121786923;
        double longitude5 = 23.4335112530525;
        double latitude5 = 55.42757121786923;

        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude1,latitude1));
        coordinates.add(new Coordinates(longitude2,latitude2));
        coordinates.add(new Coordinates(longitude3,latitude3));
        coordinates.add(new Coordinates(longitude4,latitude4));
        coordinates.add(new Coordinates(longitude5,latitude5));

        double locationLongitude = 23.398231035515494;
        double locationLatitude = 55.413306242333846;

        Polygon polygon = new Polygon(coordinates);

        Coordinates location = new Coordinates(locationLongitude,locationLatitude);
        try{
            assertFalse(PIP(polygon, location));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testExceptionIsThrownWhenNotValidLocationCoordinatesArePassed(){
        double longitude1 = 23.4335112530525;
        double latitude1 = 55.42757121786923;
        double longitude2 = 23.4335112530525;
        double latitude2 = 55.39275039575335;
        double longitude3 = 23.53866024454672;
        double latitude3 =  55.39275039575335;
        double longitude4 = 23.53866024454672;
        double latitude4 = 55.42757121786923;
        double longitude5 = 23.4335112530525;
        double latitude5 = 55.42757121786923;

        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(longitude1,latitude1));
        coordinates.add(new Coordinates(longitude2,latitude2));
        coordinates.add(new Coordinates(longitude3,latitude3));
        coordinates.add(new Coordinates(longitude4,latitude4));
        coordinates.add(new Coordinates(longitude5,latitude5));

        double locationLongitude = 923.398231035515494;
        double locationLatitude = 55.413306242333846;

        Polygon polygon = new Polygon(coordinates);

        Coordinates location = new Coordinates(locationLongitude,locationLatitude);

        assertThrows(Exception.class, () -> {
            PIP(polygon,location);
        });
    }
}