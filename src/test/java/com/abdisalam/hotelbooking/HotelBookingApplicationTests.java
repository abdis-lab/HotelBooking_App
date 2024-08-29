package com.abdisalam.hotelbooking;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.repository.HotelRepository;
import com.abdisalam.hotelbooking.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class HotelBookingApplicationTests {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    private Hotel hotel;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        hotel = new Hotel(1L, "New Hotel", "123 Street", "City", "Great Hotel", "imagePath.jpg", new ArrayList<>());
    }

//    @Test
//    public void testGetHotelById(){
//        HotelDto hotelDto = new HotelDto(1L, "New Hotel", "123 Street", "City", "Great Hotel", , "/image.jpeg");
//        when(hotelService.getHotelById(1L)).thenReturn(hotelDto);
//
//        HotelDto result = testedClass.getHotelById(1L);
//        assertNotNull(result);
//        assertEquals("New Hotel", result.getName());
//    }
}
