package entities;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class Location {
    private final String name;
    private final Coordinates coordinates;

    @JsonCreator
    public Location(@JsonProperty("name") String name,@JsonProperty("coordinates") List<Double> coordinates) {
        this.name = name;
        this.coordinates = new Coordinates(coordinates.get(0), coordinates.get(1));
    }

    public String getName() {
        String currentName = new String(this.name);
        return currentName;
    }

    public Coordinates getCoordinates() {
        Coordinates currentCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude());
        return currentCoordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\''  + coordinates +
                '}';
    }
}
