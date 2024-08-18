package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.model.RoomType;
import com.abdisalam.hotelbooking.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImp implements RoomTypeService{

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImp(RoomTypeRepository roomTypeRepository){
        this.roomTypeRepository = roomTypeRepository;
    }


    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType getRoomTypeById(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRoomType(RoomType roomType) {
        roomTypeRepository.delete(roomType);
    }
}
