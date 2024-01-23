package com.micro.ratings.Services;


import com.micro.ratings.Repo.RatingRepo;
import com.micro.ratings.entities.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServices {

    @Autowired
   public RatingRepo ratingRepo;

    public Ratings create(Ratings ratings){
        String randomUserId = UUID.randomUUID().toString();
        ratings.setRatingId(randomUserId);
        return ratingRepo.save(ratings);
    }

    public List<Ratings> getAllHotels(){
        return ratingRepo.findAll();
    }

    public Optional<Ratings> finById(String id){
        return ratingRepo.findById(id);
    }
    public List<Ratings> findByHotelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
    public List<Ratings> findByUserId(String userId){
        return ratingRepo.findByUserId(userId);
    }
}
