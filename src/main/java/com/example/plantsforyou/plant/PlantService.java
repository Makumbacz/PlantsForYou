package com.example.plantsforyou.plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> getPlants(){
        return plantRepository.findAll();
    }
    public void addPlant(Plant plant){
        plantRepository.save(plant);
    }
}
