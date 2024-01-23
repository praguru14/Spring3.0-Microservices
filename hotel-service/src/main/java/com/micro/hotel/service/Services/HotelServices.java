package com.micro.hotel.service.Services;

import com.micro.hotel.service.Repo.HotelRepo;
import com.micro.hotel.service.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServices {

    @Autowired
   public HotelRepo hotelRepo;

    public Hotel create(Hotel hotel){
        String randomUserId = UUID.randomUUID().toString();
        hotel.setId(randomUserId);
        return hotelRepo.save(hotel);
    }

    public List<Hotel> getAllHotels(){
        return hotelRepo.findAll();
    }

    public Optional<Hotel> finById(String id){
        return hotelRepo.findById(id);
    }
}
