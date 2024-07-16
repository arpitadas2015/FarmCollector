

package farmcollector.controller;

import farmcollector.model.Harvesting;
import farmcollector.repository.HarvestingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author arpit
 *
 */
@RestController
@RequestMapping("/api/harvesting")
public class HarvestingController {

    @Autowired
    private HarvestingRepository harvestingRepository;

    @PostMapping
    public Harvesting addHarvesting(@RequestBody Harvesting harvesting) {
        return harvestingRepository.save(harvesting);
    }

    @GetMapping
    public List<Harvesting> getHarvestings(@RequestParam String farmName, @RequestParam String season) {
        return harvestingRepository.findByFarmNameAndSeason(farmName, season);
    }
}
