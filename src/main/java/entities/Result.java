package entities;

import java.util.List;

public class Result {
    private String region;
    private List<String> matched_locations;

    public String getRegion() {
        return region;
    }

    public Result() {
    }


    public Result(List<String> matched_locations) {
        this.matched_locations = matched_locations;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getMatched_locations() {
        return matched_locations;
    }

    public void setMatched_locations(List<String> matched_locations) {
        this.matched_locations = matched_locations;
    }

    public void addMatcehdLocation(String location){
        matched_locations.add(location);
    }
}
