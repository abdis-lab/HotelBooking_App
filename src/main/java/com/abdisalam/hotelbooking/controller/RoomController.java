package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.model.Room;
import com.abdisalam.hotelbooking.model.RoomType;
import com.abdisalam.hotelbooking.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {


    private final RoomService roomService;
    private HotelService hotelService;
    private RoomTypeService roomTypeService;

    public RoomController(RoomService roomService, HotelService hotelService, RoomTypeService roomTypeService){
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel/{hotelId}")
    public String listRooms(@PathVariable Long hotelId, Model model){
        List<Room> rooms = roomService.getRoomsByHotelId(hotelId);
        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();

        model.addAttribute("rooms", rooms);
        model.addAttribute("hotel", hotelDto);
        model.addAttribute("roomTypes", roomTypes);
        model.addAttribute("room", new Room());
        model.addAttribute("roomType", new RoomType());
        return "rooms";
    }


    @PostMapping("/hotel/{hotelId}/roomType/new")
    public String saveRoomType(@PathVariable Long hotelId, @ModelAttribute("roomType") RoomType roomType){
        roomTypeService.saveRoomType(roomType);
        return "redirect:/rooms/hotel/" + hotelId;
    }


    @GetMapping("/hotel/{hotelId}/new")
    public String createRoomForm(@PathVariable Long hotelId, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "rooms";
        }

        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        List<RoomType> roomType = roomTypeService.getAllRoomTypes();
        List<Room> rooms = roomService.getAllRooms();


        model.addAttribute("roomType", new RoomType());
        model.addAttribute("rooms", new Room());
        model.addAttribute("hotel", hotelDto);
        model.addAttribute("roomTypes", roomType);


        return "rooms";


    }


    @PostMapping("/hotel/{hotelId}/room/new")
    public String saveRoom(@PathVariable Long hotelId,
                           @ModelAttribute("room") Room room){

        //Associating Room with the hotel and roomType
        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        Hotel hotel = HotelConverter.convertToEntity(hotelDto);

        RoomType roomType = roomTypeService.getRoomTypeById(room.getRoomType().getId());

        room.setHotel(hotel);
        room.setRoomType(roomType);

        roomService.saveRoom(room);
        return "redirect:/rooms/hotel/" + hotelId;
    }


    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute("room") Room room){
        room.setId(id);
        roomService.saveRoom(room);
        return "redirect:/hotel_room";
    }


    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return "redirect:/hotel_room";
    }

}
