package farmcollector.controller;

import farmcollector.model.Planting;
import farmcollector.repository.PlantingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author arpit
 *
 */
@RestController
@RequestMapping("/api")
public class PlantingController {

    @Autowired
    private PlantingRepository plantingRepository;

    @PostMapping("/planting")
    public ResponseEntity<Planting> addPlanting(@RequestBody Planting planting) {
        Planting savedPlanting = plantingRepository.save(planting);
        return ResponseEntity.ok(savedPlanting);
    }

    @GetMapping("/planting")
    public List<Planting> getAllPlantings() {
        return plantingRepository.findAll();
    }
}
