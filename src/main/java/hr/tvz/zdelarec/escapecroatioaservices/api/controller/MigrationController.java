package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import hr.tvz.zdelarec.escapecroatioaservices.entity.FinishedRoom;
import hr.tvz.zdelarec.escapecroatioaservices.entity.RoomDetails;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;
import hr.tvz.zdelarec.escapecroatioaservices.repository.FinishedRoomsRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomDetailsRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom.FinishedRoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.roomDetails.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Application migration controller.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = "/api/migrate", produces = "application/json")
@CrossOrigin
public class MigrationController {

    @Autowired
    private FinishedRoomsRepository finishedRoomsRepository;

    @Autowired
    private RoomDetailsRepository roomDetailsRepository;

    @GetMapping
    public void migrate() {
        final List<FinishedRoom> finishedRooms = (List<FinishedRoom>) finishedRoomsRepository.findAll();

        /*for (FinishedRoom finishedRoom : finishedRooms) {
            System.out.println("Converting");
            System.out.println(finishedRoom);
            System.out.println("");

            final RoomDetails roomDetails = new RoomDetails();
            roomDetails.setCityId(finishedRoom.getCityId());
            roomDetails.setPlaceId(finishedRoom.getPlaceId());
            roomDetails.setRoomId(finishedRoom.getRoomId());
            roomDetails.setUserId(finishedRoom.getUserId());
            roomDetails.setRoomStatus(RoomStatusEnum.GAME_WON);


            System.out.println("Conversion completed. Result:");
            System.out.println(roomDetails);

            roomDetailsRepository.save(roomDetails);
        }*/
    }
}
