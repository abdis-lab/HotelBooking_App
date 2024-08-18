package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.model.Room;
import com.abdisalam.hotelbooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService{

    private RoomRepository roomRepository;

    public RoomServiceImp(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id){
        return roomRepository.findById(id).orElse(null);
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }
}
