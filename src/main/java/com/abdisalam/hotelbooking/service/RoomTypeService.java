package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.model.RoomType;
import com.abdisalam.hotelbooking.repository.RoomTypeRepository;

import java.util.List;

public interface RoomTypeService {

    List<RoomType> getAllRoomTypes();

    RoomType saveRoomType(RoomType roomType);

    RoomType getRoomTypeById(Long id);

    void deleteRoomType(RoomType roomType);
}
