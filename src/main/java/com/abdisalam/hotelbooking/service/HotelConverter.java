package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.dto.RoomDto;
import com.abdisalam.hotelbooking.dto.RoomTypeDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class HotelConverter {

    public static HotelDto convertToDTO(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setAddress(hotel.getAddress());
        hotelDto.setCity(hotel.getCity());
        hotelDto.setDescription(hotel.getDescription());
        hotelDto.setImagePath(hotel.getImage());

        // Convert Rooms
        List<RoomDto> roomDtos = hotel.getRooms().stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setId(room.getId());
            roomDto.setRoomNumber(room.getRoomNumber());
            roomDto.setPrice(room.getPrice());
            roomDto.setRoomTypeName(room.getRoomType().getName());
            return roomDto;
        }).collect(Collectors.toList());

        hotelDto.setRooms(roomDtos);

        // Convert Room Types
        List<RoomTypeDto> roomTypeDtos = hotel.getRooms().stream()
                .map(Room::getRoomType)
                .distinct()
                .map(roomType -> new RoomTypeDto(roomType.getId(), roomType.getName(), roomType.getDescription()))
                .collect(Collectors.toList());

        hotelDto.setRoomTypes(roomTypeDtos);

        return hotelDto;
    }

    public static Hotel convertToEntity(HotelDto hotelDto, String imagePath) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setCity(hotelDto.getCity());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setImage(imagePath);
        return hotel;
    }

    public static Hotel convertToEntity(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setCity(hotelDto.getCity());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setImage(hotelDto.getImagePath());
        return hotel;
    }

}
