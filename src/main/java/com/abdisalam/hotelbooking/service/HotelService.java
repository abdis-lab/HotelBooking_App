package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.dto.HotelDto;
import com.abdisalam.hotelbooking.model.Hotel;
import com.abdisalam.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class HotelService {


    private final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }


    @Value("${upload.dir")
    private String uploadDir;

    public List<HotelDto> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(HotelConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public HotelDto getHotelById(Long id){
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return hotel != null ? HotelConverter.convertToDTO(hotel) : null;
    }

    public void saveHotel(HotelDto hotelDto) throws Exception{
        MultipartFile imageFile = hotelDto.getImageFile();
        String imagePath = null;

        if(imageFile != null && !imageFile.isEmpty()){
            String uploadDir = "src/main/resources/static/uploads/";

            String fileName = imageFile.getOriginalFilename();

            Path path = Paths.get(uploadDir + fileName);

            Files.createDirectories(path.getParent());

            Files.write(path, imageFile.getBytes());

            imagePath = "/uploads/" + fileName;

//            byte[] bytes = imageFile.getBytes();

//            Files.write(path, bytes);
//
//            imagePath = "/uploads/" + imageFile.getOriginalFilename();
        }

        Hotel hotel = HotelConverter.convertToEntity(hotelDto, imagePath);

        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id){
        hotelRepository.deleteById(id);
    }
}
