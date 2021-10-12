package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDetailsDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.v2.RoomDtoV2;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Mapping implementation for {@link Room} entity and {@link RoomDtoV2}.
 *
 * @author kristijan.zdelarec
 */
public class RoomMapperV2 implements BasicMapper<RoomDtoV2, Room> {

    private ModelMapper modelMapper;
    private List<RoomDetailsDto> roomDetailsDtoList;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     * @param roomDetailsDtoList list of {@link RoomDetailsDto} objects
     */
    public RoomMapperV2(final ModelMapper modelMapper, final List<RoomDetailsDto> roomDetailsDtoList) {
        this.modelMapper = modelMapper;
        this.roomDetailsDtoList = roomDetailsDtoList;
    }

    @Override
    public RoomDtoV2 mapToDto(final Room room) {
        final RoomDtoV2 roomDto =  modelMapper.map(room, RoomDtoV2.class);
        final RoomDetailsDto roomDetails = roomDetailsDtoList.stream().filter(roomDetailsDto -> roomDetailsDto.getRoomId().equals(room.getId())).findFirst().orElse(null);
        if (roomDetails == null) {
            roomDto.setRoomStatus(RoomStatusEnum.NOT_PLAYED);
        } else {
            roomDto.setRoomStatus(roomDetails.getRoomStatus());
        }
        return roomDto;
    }

    @Override
    public Room mapToEntity(final RoomDtoV2 roomDto) {
        return modelMapper.map(roomDto, Room.class);
    }
}
