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
                    88,
                    3,
                    "https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_monstera_variant_medium_grant_mint_0d014032-0bb0-4dd6-865e-f0f8a31f98c4.jpg?v=1650482391",
                    "Najbardziej pożądana roślina we wnętrzach ostatnich lat, czule nazwana przez nas Grzegorzem, zawdzięcza swoją popularność nie tylko wyjątkowej urodzie, ale też swojej bezproblemowości. Monstera jest jedną z tych roślin, z którymi będziesz żyć długo i szczęśliwie.",
                    PlantTypeOfLight.diffused,
                    PlantCareDifficulty.EASY,
                    PlantSize.MEDIUM,
                    true
            );
            repository.save(plant);
            plant = new Plant(
                    "Kawowiec",
                    46,
                    3,
                    "https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_monstera_variant_medium_grant_mint_0d014032-0bb0-4dd6-865e-f0f8a31f98c4.jpg?v=1650482391",
                    "Być może zaskoczy Cię fakt, że ta sama roślina, która uprawia ziarna porannej kawy, jest popularną i łatwą w utrzymaniu rośliną domową!",
                    PlantTypeOfLight.shadow,
                    PlantCareDifficulty.EASY,
                    PlantSize.SMALL,
                    true
            );
            repository.save(plant);
            plant = new Plant(
                    "Anturium Andrego",
                    59,
                    3,
                    "https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_red-anthurium_small_kent_white.jpg?v=1652382922",
                    "Znane także jako kwiat flaminga, Anthurium jest najdłużej kwitnącą rośliną domową na świecie. Rzadko można spotkać ją bez efektownych kwiatów.",
                    PlantTypeOfLight.shadow,
                    PlantCareDifficulty.EASY,
                    PlantSize.SMALL,
                    true
            );
            repository.save(plant);
            plant = new Plant(
                    "Dracaena trifasciata",
                    160,
                    5,
                    "https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_snake-plant-laurentii_large_burbank_white.jpg?v=1650310323",
                    "Sansewieria gwinejska to sukulent charakteryzujący się liśćmi przypominającymi miecz o intensywnie żółtych brzegach. Jest popularna ze względu na swój łagodny charakter - toleruje suszę i słabe oświetlenie - oraz zdolność oczyszczania powietrza. ",
                    PlantTypeOfLight.diffused,
                    PlantCareDifficulty.EASY,
                    PlantSize.BIG,
                    true
            );
            repository.save(plant);
            plant = new Plant(
                    "Zamioculcas zamiifolia",
                    165,
                    5,
                    "https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_zz-plant_large_burbank_white.jpg?v=1649186086",
                    "Roślina 'ZZ' charakteryzuje się zielonymi, woskowymi liśćmi nad powierzchnią mieszanki doniczkowej i dużymi, podobnymi do ziemniaków kłączami pod spodem. Kłącza magazynują wodę, dzięki czemu 'ZZ' jest rośliną odporną na suszę, która może tygodniami obywać się bez wody.",
                    PlantTypeOfLight.diffused,
                    PlantCareDifficulty.EASY,
                    PlantSize.BIG,
                    true
            );
            repository.save(plant);
            plant = new Plant(
                    "Peperomia Raindrop",
                    80,
                    3,
                    "https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_peperomia-raindrop_small_upcycled-planter-saucer_stonewash.jpg?v=1651001147",
                    "Peperomie stają się coraz popularniejsze w uprawie domowej ze względu na swoją dużą odporność na okresowe przesuszenie oraz oczywiście niebanalną urodę. Odmiana 'Raindrop' cechuje się dużymi liśćmi o żywej, ciemnej zieleni oraz ciekawym kształcie. Zaokrąglone blaszki liściowe mają z jednej strony ostre zakończenie nadające im formę łezki lub spadającej kropli wody -stąd nazwa odmiany 'Raindrop'. ",
                    PlantTypeOfLight.diffused,
                    PlantCareDifficulty.MEDIUM,
                    PlantSize.SMALL,
                    true
            );
            repository.save(plant);
        };
    }
}
