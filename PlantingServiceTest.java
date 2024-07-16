package farmcollector.controller;

import farmcollector.model.Planting;
import farmcollector.repository.PlantingRepository;
import farmcollector.service.PlantingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author arpit
 *
 */
@ExtendWith(MockitoExtension.class)
public class PlantingServiceTest {
    private PlantingRepository plantingRepository;
    private PlantingService plantingService;

    @BeforeEach
    public void setup() {
        plantingRepository = Mockito.mock(PlantingRepository.class);
        plantingService = new PlantingService(plantingRepository);
    }

    @Test
    public void testPlanted() {
        Planting planting = new Planting();
        planting.setFarmName("Farm1");
        planting.setSeason("Spring");
        planting.setCropType("Wheat");
        planting.setPlantingArea(10.0);
        planting.setExpectedProduct(20.0);

        when(plantingRepository.save(any(Planting.class))).thenReturn(planting);

        Planting result = plantingService.planted(10.0, "Wheat", 20.0);
        assertEquals(planting.getFarmName(), result.getFarmName());
        assertEquals(planting.getSeason(), result.getSeason());
        assertEquals(planting.getCropType(), result.getCropType());
        assertEquals(planting.getPlantingArea(), result.getPlantingArea());
        assertEquals(planting.getExpectedProduct(), result.getExpectedProduct());
    }
}
