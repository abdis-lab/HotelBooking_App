package com.abdisalam.hotelbooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String RoomNumber;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
