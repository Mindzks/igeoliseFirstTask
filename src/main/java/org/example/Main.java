package org.example;

import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import entities.Location;
import entities.Region;
import entities.Result;
import methods.PointInPolygon;

import static methods.PointInPolygon.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        File locationsJsonFile = new File("src/main/resources/locations.json");

        List<Location> locations = objectMapper.readValue(locationsJsonFile, new TypeReference<List<Location>>(){});

        File regionsJsonFile = new File("src/main/resources/regions.json");

        List<Region> regions = objectMapper.readValue(regionsJsonFile, new TypeReference<List<Region>>(){});

        List<Result> finalOutput = new ArrayList<>();

        for (Region region: regions){
            //Initializing new temporary result object with arrayList for locations list. I change it dynamically  via
            //tempResult.addMatcehdLocation(location.getName()); method
            Result tempResult = new Result(new ArrayList<>());
            tempResult.setRegion(region.getName());
            List<List<List<Double>>> regionCoordinates= region.getCoordinates();
            //One region can have multiple areas
            for (List<List<Double>> regionArea: regionCoordinates){
                for (Location location: locations){
                    if(PIP(regionArea, location.getCoordinates())){
                        tempResult.addMatcehdLocation(location.getName());
                    }
                }
            }
            finalOutput.add(tempResult);
        }

        ObjectMapper Obj2 = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string
            String jsonStr = Obj2.writeValueAsString(finalOutput);
            // Displaying Java object into a JSON string
            System.out.println(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}