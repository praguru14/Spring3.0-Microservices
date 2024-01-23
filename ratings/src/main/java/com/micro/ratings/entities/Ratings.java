package com.micro.ratings.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("ratings")
public class Ratings {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;

    private String feedback;
    private int rating;
}
