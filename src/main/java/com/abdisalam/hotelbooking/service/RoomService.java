package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.model.Room;
import com.abdisalam.hotelbooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoomService {

    Room saveRoom(Room room);

    List<Room> getAllRooms();

    List<Room> getRoomsByHotelId(Long hotelId);
    Room getRoomById(Long id);
    void deleteRoom(Long id);
}
