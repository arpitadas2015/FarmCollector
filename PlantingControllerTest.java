package farmcollector.controller;

import farmcollector.model.Planting;
import farmcollector.repository.PlantingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantingController.class)
public class PlantingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantingRepository plantingRepository;

    private Planting planting;

    @BeforeEach
    public void setup() {
        planting = new Planting();
        planting.setFarmName("MyFarm");
        planting.setSeason("Spring");
        planting.setCropType("Corn");
        planting.setPlantingArea(100);
        planting.setExpectedProduct(150);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testAddPlanting() throws Exception {
        
        when(plantingRepository.save(any(Planting.class))).thenReturn(planting);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/planting")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"farmName\":\"MyFarm\",\"season\":\"Spring\",\"cropType\":\"Corn\",\"plantingArea\":100,\"expectedProduct\":150}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.farmName").value("MyFarm"))
                .andExpect(jsonPath("$.season").value("Spring"))
                .andExpect(jsonPath("$.cropType").value("Corn"))
                .andExpect(jsonPath("$.plantingArea").value(100))
                .andExpect(jsonPath("$.expectedProduct").value(150));
    }
}
