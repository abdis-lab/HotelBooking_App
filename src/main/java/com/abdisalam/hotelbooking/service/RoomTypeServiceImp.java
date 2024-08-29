package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.model.RoomType;
import com.abdisalam.hotelbooking.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }

    public List<RoomType> getRoomTypesByHotelId(Long hotelId){
        return roomTypeRepository.findByHotelId(hotelId);
    }
}
