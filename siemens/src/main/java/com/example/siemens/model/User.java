package com.example.siemens.model;

import com.example.siemens.model.dto.RoomDto;
import com.example.siemens.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String feedback;


    @Column
    @OneToMany(cascade=CascadeType.ALL)
    private List<Room> reservedRooms;

}
