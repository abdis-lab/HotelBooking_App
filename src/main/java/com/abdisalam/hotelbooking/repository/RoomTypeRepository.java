package com.abdisalam.hotelbooking.repository;

import com.abdisalam.hotelbooking.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    List<RoomType> findByHotelId(Long hotelId);
}
