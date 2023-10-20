package entities;

import junit.framework.TestCase;
import org.junit.Test;

public class CoordinatesConstructorTest extends TestCase {
    @Test
    public void testWithLongitudeAndLatitudeObjectIsCreated(){
        double longitude = 12.123213;
        double latitude = 56.1515151;
        Coordinates coordinates = new Coordinates(longitude,latitude);
        assertEquals(longitude, coordinates.getLongitude());
        assertEquals(latitude, coordinates.getLatitude());
    }

    @Test
    public void testLongitudeIsReturned(){
        double longitude = 12.123213;
        double latitude = 56.1515151;
        Coordinates coordinates = new Coordinates(longitude,latitude);
        assertEquals(longitude, coordinates.getLongitude());
    }
    @Test
    public void testLatitudeIsReturned(){
        double longitude = 12.123213;
        double latitude = 56.1515151;
        Coordinates coordinates = new Coordinates(longitude,latitude);
        assertEquals(latitude, coordinates.getLatitude());
    }






}