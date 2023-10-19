package entities;

import java.util.List;

public class Region {
    private String name;
    private List<List<List<Double>>> coordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<List<Double>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<Double>>> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
