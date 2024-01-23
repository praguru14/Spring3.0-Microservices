package com.micro.hotel.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "hotel")
public class Hotel {

    @Id
    private String Id;
    private String name;
    private String location;
    private String about;
}
