package com.abdisalam.hotelbooking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long id;
    private String roomNumber;
    private double price;
    private String roomTypeName;


}
