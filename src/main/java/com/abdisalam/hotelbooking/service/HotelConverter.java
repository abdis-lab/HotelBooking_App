package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;

public class HotelConverter {

    public static HotelDto convertToDTO(Hotel hotel){
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setAddress(hotel.getAddress());
        hotelDto.setCity(hotel.getCity());
        hotelDto.setDescription(hotel.getDescription());
        hotelDto.setImagePath(hotel.getImage());
        return hotelDto;
    }

    public static Hotel convertToEntity(HotelDto hotelDto, String imagePath){
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setCity(hotelDto.getCity());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setImage(imagePath);
        return hotel;
    }

}
