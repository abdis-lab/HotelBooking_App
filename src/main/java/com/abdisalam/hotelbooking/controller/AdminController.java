package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.service.HotelConverter;
import com.abdisalam.hotelbooking.service.HotelService;
import com.abdisalam.hotelbooking.service.RoomService;
import com.abdisalam.hotelbooking.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final HotelService hotelService;
    private final RoomService roomService;
    private final RoomTypeService roomTypeService;


    public AdminController(HotelService hotelService, RoomService roomService, RoomTypeService roomTypeService){
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard(Model model){
        List<HotelDto> hotelDto = hotelService.getAllHotels();
//        List<Room> rooms = roomService.getAllRooms();
//        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();

        model.addAttribute("hotels", hotelDto);
//        model.addAttribute("rooms", rooms);
//        model.addAttribute("roomTypes", roomTypes);


        return "admin/dashboard";
    }

    @GetMapping("/hotels/{hotelId}/details")
    @ResponseBody
    public Hotel getHotelDetails(@PathVariable Long hotelId){
        HotelDto hotel = hotelService.getHotelById(hotelId);
        return HotelConverter.convertToEntity(hotel);
    }


    //Mange Hotels

    @GetMapping("/hotels/new")
    public String createHotelForm(Model model){
        model.addAttribute("hotelDto", new HotelDto());
        return "/admin/create_hotel";
    }

    //Adding the hotel To the DB
    @PostMapping("/hotels/new")
    public String addHotel(@ModelAttribute("hotelDto") HotelDto hotelDto, BindingResult bindingResult, Model model) throws Exception{
        if(bindingResult.hasErrors()){
            return "admin/create_hotel";
        }

        hotelService.saveHotel(hotelDto);
        return "redirect:/admin/adminDashboard";
    }


    //Get mapping for the edit form
    @GetMapping("/hotels/edit/{id}")
    public String editHotelForm(@PathVariable Long id, Model model){
        HotelDto hotelDto = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotelDto);
        return "admin/edit_hotel";
    }

    @PostMapping("/hotels/update/{id}")
    public String updateHotel(@PathVariable Long id, @ModelAttribute("hotel") HotelDto hotelDto, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return "admin/manage_hotels";
        }

        hotelDto.setId(id);
        hotelService.saveHotel(hotelDto);
        return "redirect:/admin/hotels";
    }

    @GetMapping("/hotels/delete/{id}")
    public String deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return "redirect:/admin/hotels";
    }


//    //Manage Rooms
//    @GetMapping("/rooms")
//    public String manageRooms(Model model){
//        List<Room> rooms = roomService.getAllRooms();
//        model.addAttribute("rooms", rooms);
//        return "admin/admin-dashboard";
//    }
//
//
//    @GetMapping("/rooms/new")
//    public String createRoomForm(Model model){
//        model.addAttribute("room", new Room());
//        model.addAttribute("hotels", hotelService.getAllHotels());
//        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
//        return "admin/admin-dashboard";
//    }
//
//
//    @PostMapping("/rooms/edit/{id}")
//    public String addRoom(@ModelAttribute("room") Room room){
//        roomService.saveRoom(room);
//        return "redirect:/admin/rooms";
//    }
//
//
//    @GetMapping("/rooms/edit/{id}")
//    public String editRoomForm(@PathVariable Long id, Model model){
//        Room room = roomService.getRoomById(id);
//        model.addAttribute("room", room);
//        model.addAttribute("hotels", hotelService.getAllHotels());
//        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
//        return "admin/admin-dashboard";
//    }
//
//    @PostMapping("/rooms/update/{id}")
//    public String updateRoom(@PathVariable Long id, @ModelAttribute("room") Room room){
//        room.setId(id);
//        roomService.saveRoom(room);
//        return "redirect:/admin/rooms";
//    }
//
//
//    @GetMapping("/rooms/delete/{id}")
//    public String deleteRoom(@PathVariable Long id){
//        roomService.deleteRoom(id);
//        return "redirect:/admin/rooms";
//    }
//
//    //Manage Room Types
//    @GetMapping("/room-types")
//    public String manageRoomTypes(Model model){
//        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
//        model.addAttribute("roomTypes", roomTypes);
//        return "admin/admin-dashboard";
//    }
//
//
//    @GetMapping("/room-types/new")
//    public String createRoomTypeForm(Model model){
//        model.addAttribute("roomType", new RoomType());
//        return "admin/admin-dashboard";
//    }
//
//    @GetMapping("/hotel/{hotelId}/roomTypes")
//    public String manageRoomTypes(@PathVariable Long hotelId, Model model) {
//        HotelDto hotelDto = hotelService.getHotelById(hotelId);
//        List<RoomType> roomTypes = roomTypeService.getRoomTypesByHotelId(hotelId);
//
//        model.addAttribute("hotel", hotelDto);
//        model.addAttribute("roomTypes", roomTypes);
//        model.addAttribute("roomType", new RoomType());
//
//        return "admin/admin-dashboard";  // Or whatever the template name is for your dashboard
//    }
//
//    @PostMapping("/room-types/new")
//    public String addRoomType(@ModelAttribute("roomType") RoomType roomType){
//        roomTypeService.saveRoomType(roomType);
//        return "redirect:/admin/room-types";
//    }
//
//
//    @GetMapping("/room-types/delete/{id}")
//    public String deleteRoomType(@PathVariable Long id){
//        roomTypeService.deleteRoomType(id);
//        return "admin/admin-dashboard";
//    }
//




}
