package org.example;

import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import entities.*;

import static methods.PointInPolygon.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //Reading data from files
        ObjectMapper objectMapper = new ObjectMapper();
        File locationsJsonFile = new File("src/main/resources/locations.json");
        List<Location> locations = objectMapper.readValue(locationsJsonFile, new TypeReference<List<Location>>(){});
        File regionsJsonFile = new File("src/main/resources/regions.json");
        List<Region> regions = objectMapper.readValue(regionsJsonFile, new TypeReference<List<Region>>(){});

        //Result array
        List<Result> finalOutput = new ArrayList<>();

        for (Region region: regions){

            List<String> locationsInRegions = new ArrayList<>();

            List<Polygon> regionArea= region.getCoordinates().getArea();

            for (Polygon polygon: regionArea){
                for (Location location: locations){
                    try{
                        if(PIP(polygon, location.getCoordinates())){
                            locationsInRegions.add(location.getName());
                        }
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }
            Result tempResult = new Result(region.getName(),locationsInRegions);
            finalOutput.add(tempResult);
        }

        ObjectMapper Obj2 = new ObjectMapper();
        Obj2.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String jsonStr = Obj2.writeValueAsString(finalOutput);
            System.out.println(jsonStr);
            Files.writeString(Path.of("src/main/resources/results.json"), jsonStr, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}