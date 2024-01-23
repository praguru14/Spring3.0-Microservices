package com.micro.ratings.controllers;

import com.micro.ratings.Services.RatingServices;
import com.micro.ratings.entities.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    @PostMapping
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings ratings) {
        try {
            Ratings createdRating = ratingServices.create(ratings);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Ratings>> getAllRatings() {
        try {
            List<Ratings> ratings = ratingServices.getAllHotels();
            return ResponseEntity.ok(ratings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ratings> getRatingById(@PathVariable String id) {
        try {
            Optional<Ratings> rating = ratingServices.finById(id);
            return rating.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId) {
        try {
            List<Ratings> ratings = ratingServices.findByHotelId(hotelId);
            return ResponseEntity.ok(ratings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId) {
        try {
            List<Ratings> ratings = ratingServices.findByUserId(userId);
            return ResponseEntity.ok(ratings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
