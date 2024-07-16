package farmcollector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author arpit
 *
 */
@Entity
public class Planting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String farmName;
    private String season;
    private String cropType;
    private double plantingArea;
    private double expectedProduct;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getPlantingArea() {
        return plantingArea;
    }

    public void setPlantingArea(double plantingArea) {
        this.plantingArea = plantingArea;
    }

    public double getExpectedProduct() {
        return expectedProduct;
    }

    public void setExpectedProduct(double expectedProduct) {
        this.expectedProduct = expectedProduct;
    }
}
