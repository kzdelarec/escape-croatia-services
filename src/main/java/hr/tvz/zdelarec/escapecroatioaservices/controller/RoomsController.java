package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.city.CityService;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Contains mappings related to the rooms page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/rooms"})
public class RoomsController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomsController.class);

    /**
     * Autowired {@link CityService}.
     */
    @Autowired
    private CityService cityService;

    /**
     * Autowired {@link PlaceService}.
     */
    @Autowired
    private PlaceService placeService;

    /**
     * Autowired {@link RoomService}.
     */
    @Autowired
    private RoomService roomService;

    /**
     * Get rooms view page.
     *
     * @param model view model
     * @return view name
     */
    @GetMapping
    public String showRooms(final Model model) {
        LOGGER.debug("Showing rooms page");
        final Map<Integer, CityDto> cityMap = cityService.getAllCities().stream().collect(Collectors.toMap(CityDto::getId, Function.identity()));
        final Map<Integer, PlaceDto> placesMap = placeService.getAllPlaces().stream().collect(Collectors.toMap(PlaceDto::getId, Function.identity()));
        final List<RoomDto> roomDtoList = roomService.getRoomsByAuthority();
        model.addAttribute("rooms", roomDtoList);
        model.addAttribute("cities", cityMap);
        model.addAttribute("places", placesMap);
        return "rooms";
    }

    /**
     * Get room view page by place identifier.
     *
     * @param id {@link PlaceDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/{id}")
    public String showRoomsByPlaceId(final Model model, @PathVariable("id") final Integer id) {
        LOGGER.debug("Showing rooms page");
        final Map<Integer, CityDto> cityMap = cityService.getAllCities().stream().collect(Collectors.toMap(CityDto::getId, Function.identity()));
        final Map<Integer, PlaceDto> placesMap = placeService.getAllPlaces().stream().collect(Collectors.toMap(PlaceDto::getId, Function.identity()));
        final List<RoomDto> roomDtoList = roomService.getAllRoomsByPlaceId(id);
        model.addAttribute("rooms", roomDtoList);
        model.addAttribute("places", placesMap);
        model.addAttribute("cities", cityMap);
        return "rooms";
    }

    /**
     * Show page for creating a new room.
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/new")
    public String newRoom(final Model model) {
        model.addAttribute("roomDto", new RoomDto());
        model.addAttribute("places", placeService.getPlacesByAuthority());
        return "newRoom";
    }

    /**
     * Redirect for saving and displaying rooms page.
     * @param roomDto {@link RoomDto} object
     * @param model view model
     * @return view name
     */
    @PostMapping(path = "/save")
    public String saveRoom(@Validated final RoomDto roomDto, final Model model) {
        roomDto.setCityId(placeService.getPlaceById(roomDto.getPlaceId()).getCityId());
        roomService.save(roomDto);
        return "redirect:/rooms";
    }

    /**
     * Show page for editing a new room.
     * @param model view model
     * @param id {@link RoomDto} identifier
     * @return view name
     */
    @GetMapping(path = "/edit/{id}")
    public String editRoom(final Model model, @PathVariable("id") final Integer id) {
        model.addAttribute(roomService.getRoomById(id));
        model.addAttribute("places", placeService.getAllPlaces());
        return "newRoom";
    }

    /**
     * Redirect for deleting and displaying rooms page.
     * @param id {@link RoomDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/delete/{id}")
    public String deleteRoom(final Model model, @PathVariable("id") final Integer id) {
        roomService.delete(roomService.getRoomById(id));
        return "redirect:/rooms";
    }

}
