package com.abdisalam.hotelbooking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeDto {

    private Long id;
    private String name;
    private String description;
}
