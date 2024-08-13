package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.model.Room;
import com.abdisalam.hotelbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public String listRooms(Model model){
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "hotels";
    }


    @GetMapping("/{id}")
    public String viewRoom(@PathVariable Long id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "rooms";
    }

    @GetMapping("/newroom")
    public String createRoomForm(Model model){
        model.addAttribute("room", new Room());
        return "hotels";
    }

    @PostMapping
    public String saveRoom(@ModelAttribute("room") Room room){
        roomService.saveRoom(room);
        return "redirect:/hotels";
    }


//    @GetMapping("/edit/{id}")
//    public String editRoomForm(@PathVariable Long id, Model model){
//        Room room = roomService.getRoomById(id);
//        model.addAttribute("room", room);
//        return "hotel_room";
//    }


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
