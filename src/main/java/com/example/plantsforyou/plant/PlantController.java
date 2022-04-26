package com.example.plantsforyou.plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plants")
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> getPlants(){
        return plantService.getAllPlants();
    }

    @GetMapping(path = "no-auth") //ONLY FOR TESTING
    public List<Plant> getPlantsNoAuth(){
        return plantService.getAllPlants();
    }
}
