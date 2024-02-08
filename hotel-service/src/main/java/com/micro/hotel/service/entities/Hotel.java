package com.micro.hotel.service.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hotel")
public class Hotel {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private String Id;
    private String name;
    private String location;
    private String about;
}
