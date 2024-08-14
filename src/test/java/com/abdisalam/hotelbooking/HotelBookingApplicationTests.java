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

import java.util.Optional;

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
        hotel = new Hotel(1L, "New Hotel", "123 Street", "City", "Great Hotel", "imagePath.jpg");
    }

    @Test
    public void testGetHotelById(){
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        HotelDto hotelDto = hotelService.getHotelById(1L);

        assertEquals("City", hotelDto.getName());
    }
}
