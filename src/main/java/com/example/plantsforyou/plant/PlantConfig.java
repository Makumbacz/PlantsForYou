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
                    25.12,
                    3,
                    "Najbardziej pożądana roślina we wnętrzach ostatnich lat, czule nazwana przez nas Grzegorzem, zawdzięcza swoją popularność nie tylko wyjątkowej urodzie, ale też swojej bezproblemowości. Monstera jest jedną z tych roślin, z którymi będziesz żyć długo i szczęśliwie.",
                    PlantTypeOfLight.diffused,
                    PlantCareDifficulty.EASY,
                    PlantSize.MEDIUM,
                    true
            );
            repository.save(plant);
            plant = new Plant(
                    "Scindapsus pictus 'Argyraeus'",
                    59.0,
                    4,
                    "Nie ma wielkich wymagań i zdecydowanie nadaje się dla początkujących opiekunów. Z Agatką łatwo stworzysz wrażenie gęstej dżungli. Wystarczy, że spuścisz jej pnącza kurtyną z wysokiej półki, albo belki pod sufitem.",
                    PlantTypeOfLight.direct,
                    PlantCareDifficulty.MEDIUM,
                    PlantSize.MEDIUM,
                    false
            );
            repository.save(plant);
        };
    }
}
