package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Contributor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Contributor repository.
 *
 * @author kristijan.zdelarec
 */
public interface ContributorRepository extends CrudRepository<Contributor, Integer> {

    List<Contributor> findAll();
}
