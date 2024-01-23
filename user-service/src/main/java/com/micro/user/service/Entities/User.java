package com.micro.user.service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;
    private String name;
    private String email;

    private String about;

    @Transient
    private List<Rating> ratings= new ArrayList<>();
}
