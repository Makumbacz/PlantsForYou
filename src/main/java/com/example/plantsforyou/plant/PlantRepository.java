package com.example.plantsforyou.plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findByName(String name);
    Plant findById(long id);

}
