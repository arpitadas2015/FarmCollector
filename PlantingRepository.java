
package farmcollector.repository;

import farmcollector.model.Planting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author arpit
 *
 */
public interface PlantingRepository extends JpaRepository<Planting, Long> {
    List<Planting> findByFarmNameAndSeason(String farmName, String season);
    List<Planting> findBySeason(String season);
}


