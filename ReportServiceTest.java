package farmcollector.controller;

import farmcollector.model.Planting;
import farmcollector.model.Harvesting;
import farmcollector.repository.PlantingRepository;
import farmcollector.service.ReportService;
import farmcollector.repository.HarvestingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author arpit
 *
 */
/**
 * @author arpit
 *
 */
public class ReportServiceTest {
    private PlantingRepository plantingRepository;
    private HarvestingRepository harvestingRepository;
    private ReportService reportService;

    @BeforeEach
    public void setup() {
        plantingRepository = Mockito.mock(PlantingRepository.class);
        harvestingRepository = Mockito.mock(HarvestingRepository.class);
        reportService = new ReportService();
    }

    @Test
    public void testGenerateReport() {
        // Create some mock data
        Planting planting = new Planting();
        // Set properties for planting
        Harvesting harvesting = new Harvesting();
        // Set properties for harvesting

        List<Planting> plantings = Arrays.asList(planting);
        List<Harvesting> harvestings = Arrays.asList(harvesting);

        // Stub the repository methods
        when(plantingRepository.findBySeason(anyString())).thenReturn(plantings);
        when(harvestingRepository.findBySeason(anyString())).thenReturn(harvestings);

        // Call the method under test
        String report = reportService.generateReport("Spring");

        // Verify the results (this will depend on your exact requirements)
        assertEquals("Expected report", report);
    }
}
