package farmcollector.service;

import farmcollector.model.Planting;
import farmcollector.repository.PlantingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author arpit
 *
 */
@Service
public class PlantingService {

    private final PlantingRepository plantingRepository;

    @Autowired
    public PlantingService(PlantingRepository plantingRepository) {
        this.plantingRepository = plantingRepository;
    }

    public Planting planted(double area, String cropType, double expectedProduct) {
        Planting planting = new Planting();
        planting.setPlantingArea(area);
        planting.setCropType(cropType);
        planting.setExpectedProduct(expectedProduct);
        return plantingRepository.save(planting);
    }
    
    public List<Planting> getPlantingsByFarmNameAndSeason(String farmName, String season) {
        return plantingRepository.findByFarmNameAndSeason(farmName, season);
    }

    public List<Planting> getPlantingsBySeason(String season) {
        return plantingRepository.findBySeason(season);
    }

}
