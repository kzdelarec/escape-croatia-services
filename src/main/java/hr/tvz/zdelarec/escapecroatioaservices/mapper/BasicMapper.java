package hr.tvz.zdelarec.escapecroatioaservices.mapper;

public interface BasicMapper<D,E> {
     D mapToDto(E entity);
     E mapToEntity(D dto);
}
