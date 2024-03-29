package com.micro.user.service.Entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
