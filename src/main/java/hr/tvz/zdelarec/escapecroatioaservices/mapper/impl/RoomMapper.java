package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FinishedRoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

/**
 * Mapping implementation for {@link Room} entity and {@link RoomDto}.
 *
 * @author kristijan.zdelarec
 */
public class RoomMapper implements BasicMapper<RoomDto, Room> {

    private ModelMapper modelMapper;
    private List<FinishedRoomDto> finishedRoomDtoList;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     * @param finishedRoomDtoList list of {@link FinishedRoomDto} objects
     */
    public RoomMapper(final ModelMapper modelMapper, final List<FinishedRoomDto> finishedRoomDtoList) {
        this.modelMapper = modelMapper;
        this.finishedRoomDtoList = finishedRoomDtoList;
    }

    @Override
    public RoomDto mapToDto(final Room room) {
        final RoomDto roomDto =  modelMapper.map(room, RoomDto.class);
        roomDto.setFinished(finishedRoomDtoList.stream().anyMatch(finishedRoomDto -> Objects.equals(finishedRoomDto.getRoomId(), roomDto.getId())));
        return roomDto;
    }

    @Override
    public Room mapToEntity(final RoomDto roomDto) {
        return modelMapper.map(roomDto, Room.class);
    }
}
