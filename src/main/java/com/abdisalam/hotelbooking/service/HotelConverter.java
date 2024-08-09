package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;

public class HotelConverter {

    public static HotelDto convertToDTO(Hotel hotel){
        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getCity(),
                hotel.getDescription()
        );
    }

    public static Hotel convertToEntity(HotelDto hotelDto){
        return new Hotel(
                hotelDto.getId(),
                hotelDto.getAddress(),
                hotelDto.getCity(),
                hotelDto.getName(),
                hotelDto.getDescription()
        );
    }

}
