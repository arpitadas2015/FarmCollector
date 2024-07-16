
package farmcollector.service;

import farmcollector.model.Planting;
import farmcollector.model.Harvesting;
import farmcollector.repository.PlantingRepository;
import farmcollector.repository.HarvestingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author arpit
 *
 */
@Service
public class ReportService {

    @Autowired
    private PlantingRepository plantingRepository;

    @Autowired
    private HarvestingRepository harvestingRepository;

    public String generateReport(String season) {
        List<Planting> plantings = plantingRepository.findBySeason(season);
        List<Harvesting> harvestings = harvestingRepository.findBySeason(season);

        StringBuilder report = new StringBuilder();
        report.append("Season: ").append(season).append("\n\n");

        plantings.stream()
            .collect(Collectors.groupingBy(Planting::getFarmName))
            .forEach((farmName, farmPlantings) -> {
                report.append("Farm: ").append(farmName).append("\n");
                farmPlantings.forEach(planting -> {
                    double actual = harvestings.stream()
                        .filter(h -> h.getFarmName().equals(farmName) && h.getCropType().equals(planting.getCropType()))
                        .mapToDouble(Harvesting::getActualProduct).sum();
                    report.append("  Crop: ").append(planting.getCropType()).append("\n")
                        .append("    Expected: ").append(planting.getExpectedProduct()).append(" tons\n")
                        .append("    Actual: ").append(actual).append(" tons\n");
                });
                report.append("\n");
            });

        plantings.stream()
            .collect(Collectors.groupingBy(Planting::getCropType))
            .forEach((cropType, cropPlantings) -> {
                double expected = cropPlantings.stream().mapToDouble(Planting::getExpectedProduct).sum();
                double actual = harvestings.stream()
                    .filter(h -> h.getCropType().equals(cropType))
                    .mapToDouble(Harvesting::getActualProduct).sum();
                report.append("Crop: ").append(cropType).append("\n")
                    .append("  Total Expected: ").append(expected).append(" tons\n")
                    .append("  Total Actual: ").append(actual).append(" tons\n")
                    .append("\n");
            });

        return report.toString();
    }
}
