package entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public final class Result {
    private final String region;
    private final List<String> matchedLocations;

    public String getRegion() {
        return region;
    }
    @JsonCreator
    public Result(@JsonProperty("region") String region,@JsonProperty("matchedLocations") List<String> matchedLocations) {
        this.region = region;
        this.matchedLocations = matchedLocations;
    }

    public List<String>  getLocations(){
        List<String> currentLocations = new ArrayList<>();
        for (String location: this.matchedLocations){
            currentLocations.add(location);
        }
        return currentLocations;
    }

}
