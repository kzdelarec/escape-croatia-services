package hr.tvz.zdelarec.escapecroatioaservices.mapper;

/**
 * Interface for object to object mapping.
 *
 * @author kristijan.zdelarec
 * @param <D> dto class
 * @param <E> entity class
 */
public interface BasicMapper<D, E> {

     /**
      * Method for mapping entity object to dto object.
      * @param entity entity object
      * @return dto object
      */
     D mapToDto(E entity);

     /**
      * Method for mapping dto object to entity object.
      * @param dto dto object
      * @return entity object
      */
     E mapToEntity(D dto);
}

