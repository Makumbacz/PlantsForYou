package com.example.plantsforyou.plant;

import com.example.plantsforyou.plant.enums.PlantCareDifficulty;
import com.example.plantsforyou.plant.enums.PlantSize;
import com.example.plantsforyou.plant.enums.PlantTypeOfLight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Description;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private PlantTypeOfLight typeOfLight;
    @Enumerated(EnumType.STRING)
    private PlantCareDifficulty difficulty;
    @Enumerated(EnumType.STRING)
    private PlantSize size;

    public Plant(String name,
                 String description,
                 PlantTypeOfLight typeOfLight,
                 PlantCareDifficulty difficulty,
                 PlantSize size) {
        this.name = name;
        this.description = description;
        this.typeOfLight = typeOfLight;
        this.difficulty = difficulty;
        this.size = size;
    }
}
//TODO Add price and update price method in service
// Maybe in-stock boolean?