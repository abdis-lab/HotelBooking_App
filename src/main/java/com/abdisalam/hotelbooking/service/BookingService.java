package com.abdisalam.hotelbooking.service;


import com.abdisalam.hotelbooking.repository.BookingRepository;
import com.abdisalam.hotelbooking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id){
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
}
