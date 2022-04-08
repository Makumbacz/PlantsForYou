package com.example.plantsforyou.plant;


import com.example.plantsforyou.plant.enums.PlantCareDifficulty;
import com.example.plantsforyou.plant.enums.PlantSize;
import com.example.plantsforyou.plant.enums.PlantTypeOfLight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlantConfig {
    @Bean
    CommandLineRunner commandLineRunner(PlantRepository repository){
        return args -> {
            Plant plant = new Plant(
                    "Monstera deliciosa",
                    "Najbardziej pożądana roślina we wnętrzach ostatnich lat, czule nazwana przez nas Grzegorzem, zawdzięcza swoją popularność nie tylko wyjątkowej urodzie, ale też swojej bezproblemowości. Monstera jest jedną z tych roślin, z którymi będziesz żyć długo i szczęśliwie.",
                    PlantTypeOfLight.diffused,
                    PlantCareDifficulty.EASY,
                    PlantSize.MEDIUM
            );
            repository.save(plant);
        };
    }
}
//Adding one plant to db for testing purposes
//TODO: POST mapping GET mapping
