package com.micro.user.service.services;

import com.micro.user.service.Entities.Hotel;
import com.micro.user.service.Entities.Rating;
import com.micro.user.service.Entities.User;
import com.micro.user.service.external.services.HotelService;
import com.micro.user.service.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServices {

    private final String url = "http://RATINGS-SERVICE/ratings/user/";

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(String id) {
        try {
            User user = userRepo.findById(id).orElseThrow();

            Rating[] ratingsOfUser = restTemplate.getForObject(url + user.getUserId(), Rating[].class);
            log.info("Ratings received for user {}: {}", user.getUserId(), Arrays.toString(ratingsOfUser));

            List<Rating> ratingList = Arrays.asList(ratingsOfUser);
            for (Rating rating : ratingList) {
                try {
                    Hotel forEntity = hotelService.getHotel(rating.getHotelId());
                   // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
                    rating.setHotel(forEntity);
                } catch (RestClientException e) {
                    log.error("Error occurred while fetching hotel data for rating: {}", rating.getRatingId(), e);
                }
            }
            user.setRatings(ratingList);

            return user;
        } catch (Exception e) {
            log.error("Error occurred while fetching user data", e);
            throw e; // Rethrow the exception to return a 500 status code
        }
    }


}
