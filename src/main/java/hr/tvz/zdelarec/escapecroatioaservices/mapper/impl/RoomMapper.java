package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import org.modelmapper.ModelMapper;

/**
 * Mapping implementation for {@link Room} entity and {@link RoomDto}.
 *
 * @author kristijan.zdelarec
 */
public class RoomMapper implements BasicMapper<RoomDto, Room> {

    /**
     * Autowired {@link ModelMapper}.
     */
    private ModelMapper modelMapper;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     */
    public RoomMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomDto mapToDto(final Room room) {
        final RoomDto roomDto =  modelMapper.map(room, RoomDto.class);
        roomDto.setFinished(false);
        return roomDto;
    }

    @Override
    public Room mapToEntity(final RoomDto roomDto) {
        return modelMapper.map(roomDto, Room.class);
    }
}
