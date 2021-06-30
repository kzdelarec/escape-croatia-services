package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path= RoomController.BASE_URL)
@CrossOrigin
public class RoomController {
    public static final String BASE_URL = "/room";

    @Autowired
    private RoomService roomService;

    @GetMapping(produces = RoomDto.CONTENT_TYPE)
    public List<Room> getAll(){
        return roomService.getAllRooms();
    }

    @GetMapping(path="/{id}", produces = RoomDto.CONTENT_TYPE)
    public Room getById(@PathVariable("id") final Integer id){
        return roomService.getRoomById(id).orElseThrow();
    }
}
