package com.example.plantsforyou.plant;

import com.example.plantsforyou.exceptions.RejectedRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }
    public Plant findPlantById(Long plantID) throws RejectedRequestException {
        Optional<Plant> plant = plantRepository.findById(plantID);
        if(plant.isPresent()){
            return plant.get();
        }
        throw new RejectedRequestException("Plant does not exist",HttpStatus.BAD_REQUEST);
    }
    public void addPlant(Plant plant){
        plantRepository.save(plant);
    }

    public void delete(Long plantID) {
        plantRepository.deleteById(plantID);
    }
    public void updatePrice(Long plantID, Double price){
        Optional<Plant> plant = plantRepository.findById(plantID);
        if(plant.isPresent()){
            Plant toUpdate = plant.get();
            toUpdate.setPrice(price);
            plantRepository.save(toUpdate);
        }
    }
    public void updateInStock(Long plantID, boolean inStock){
        Optional<Plant> plant = plantRepository.findById(plantID);
        if(plant.isPresent()){
            Plant toUpdate = plant.get();
            toUpdate.setInStock(inStock);
            plantRepository.save(toUpdate);
        }
    }

}
