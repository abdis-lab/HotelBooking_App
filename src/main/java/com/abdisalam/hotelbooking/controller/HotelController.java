package com.abdisalam.hotelbooking.controller;


import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{id}")
    public String viewHotel(@PathVariable Long id, Model model){
        HotelDto hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);

        return "hotel";
    }

    @GetMapping
    public String listHotels(Model model){
        List<HotelDto> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);

        return "hotels";
    }

    @GetMapping("/new")
    public String createHotelForm(Model model){
        model.addAttribute("hotel", new Hotel());
        return "create_hotel";
    }

    @PostMapping
    public String saveHotel(@ModelAttribute("hotel") @Valid HotelDto hotelDto, BindingResult result){
        if(result.hasErrors()){
            return "create_hotel";
        }
        hotelService.saveHotel(hotelDto);
        return "redirect:/hotels";
    }

    @GetMapping("/edit/{id}")
    public String editHotelForm(@PathVariable Long id, Model model){
        HotelDto hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);

        return "edit_hotel";
    }

    @PostMapping("/update/{id}")
    public String updateHotel(@PathVariable Long id, @ModelAttribute("hotel") @Valid HotelDto hotelDto, BindingResult result){
        if(result.hasErrors()){
            return "edit_hotel";
        }
        hotelDto.setId(id);
        hotelService.saveHotel(hotelDto);
        return "redirect:/hotels";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return "redirect:/hotels";
    }

}
