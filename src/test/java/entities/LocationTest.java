package entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LocationTest extends TestCase {

    @Test
    public void testLocationNameIsReturned(){
        double longitude = 12.123213;
        double latitude = 56.1515151;

        List<Double> coordinates = new ArrayList<>();

        coordinates.add(longitude);
        coordinates.add(latitude);

        String name = "locationName";

        Location newLocation = new Location(name, coordinates);

        assertEquals(name, newLocation.getName());
    }

    @Test
    public void testLocationCoordinatesIsReturned(){
        double longitude = 12.123213;
        double latitude = 56.1515151;

        List<Double> coordinates = new ArrayList<>();

        coordinates.add(longitude);
        coordinates.add(latitude);

        String name = "locationName";

        Location newLocation = new Location(name, coordinates);

        assertEquals(longitude, newLocation.getCoordinates().getLongitude());
        assertEquals(latitude, newLocation.getCoordinates().getLatitude());
    }

}