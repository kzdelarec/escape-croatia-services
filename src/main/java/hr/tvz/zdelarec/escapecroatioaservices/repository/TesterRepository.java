package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Tester;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Tester repository.
 *
 * @author kristijan.zdelarec
 */
public interface TesterRepository extends CrudRepository<Tester, Integer> {

    List<Tester> findAll();
}
