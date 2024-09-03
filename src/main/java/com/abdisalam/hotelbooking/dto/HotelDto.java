package com.abdisalam.hotelbooking.dto;

import com.abdisalam.hotelbooking.model.Room;
import com.abdisalam.hotelbooking.model.RoomType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

    private Long id;

    @NotEmpty(message = "Name is Required")
    @Size(min = 2, message = "Name Should have at least 2 characters")
    private String name;

    @NotEmpty(message = "Address is Required")
    private String address;

    @NotEmpty(message = "City is Required")
    private String city;

    private String description;


    private MultipartFile imageFile;

    private String imagePath;


    private List<RoomDto> rooms;
    private List<RoomTypeDto> roomTypes;

}
