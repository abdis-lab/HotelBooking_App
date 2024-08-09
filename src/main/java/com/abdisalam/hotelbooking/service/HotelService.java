package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDto> getAllHotels(){
        List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll();
        return hotels.stream()
                .map(HotelConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public HotelDto getHotelById(Long id){
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return hotel != null ? HotelConverter.convertToDTO(hotel) : null;
    }

    public HotelDto saveHotel(HotelDto hotelDto){
        Hotel hotel = HotelConverter.convertToEntity(hotelDto);
        Hotel savedHotel = hotelRepository.save(hotel);

        return HotelConverter.convertToDTO(savedHotel);
    }

    public void deleteHotel(Long id){
        hotelRepository.deleteById(id);
    }
}
