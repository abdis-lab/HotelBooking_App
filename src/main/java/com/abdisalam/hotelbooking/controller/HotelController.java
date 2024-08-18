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

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("/{id}")
    public String viewHotel(@PathVariable Long id, Model model){
        HotelDto hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);

        return "rooms";
    }

    @GetMapping
    public String listHotels(Model model){
        List<HotelDto> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);

        return "hotels";
    }

    @GetMapping("/new")
    public String createHotelForm(Model model){
        model.addAttribute("hotelDto", new HotelDto());
        return "create_hotel";
    }

    @PostMapping("/new")
    public String addHotel(@ModelAttribute("hotelDto") HotelDto hotelDto, BindingResult result, Model model) throws Exception{
        if(result.hasErrors()){
            return "create_hotel";
        }


        try{
            hotelService.saveHotel(hotelDto);
            model.addAttribute("successMessage", "Hotel has been successfully created");
            return "redirect:/hotels/new?success=true";
        }catch(IOException e){
            e.printStackTrace();
            model.addAttribute("errorMessage", "Image upload failed, Please try again");
            return "create_hotel";
        }
    }

    @GetMapping("/edit/{id}")
    public String editHotelForm(@PathVariable Long id, Model model){
        HotelDto hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);

        return "edit_hotel";
    }

    @PostMapping("/update/{id}")
    public String updateHotel(@PathVariable Long id, @ModelAttribute("hotel") @Valid HotelDto hotelDto, BindingResult result) throws Exception {
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
