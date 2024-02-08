package com.micro.user.service.Entities;


import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
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
