package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Developer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Developer repository.
 *
 * @author kristijan.zdelarec
 */
public interface DeveloperRepository extends CrudRepository<Developer, Integer> {

    List<Developer> findAll();
}
