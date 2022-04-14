package com.example.plantsforyou.plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findByName(String name);
    Plant findById(long id);

}
