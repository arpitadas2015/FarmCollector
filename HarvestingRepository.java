package farmcollector.repository;

import farmcollector.model.Harvesting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author arpit
 *
 */
public interface HarvestingRepository extends JpaRepository<Harvesting, Long> {
    List<Harvesting> findByFarmNameAndSeason(String farmName, String season);
    List<Harvesting> findBySeason(String season);
}
