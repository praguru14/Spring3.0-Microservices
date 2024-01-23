package com.micro.user.service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Data
@Entity
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;

    private String feedback;
    private int rating;

    @Transient
    private Hotel hotel;


}
