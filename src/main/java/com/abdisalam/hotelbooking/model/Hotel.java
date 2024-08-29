package com.abdisalam.hotelbooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String address;
    private String city;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;


}
