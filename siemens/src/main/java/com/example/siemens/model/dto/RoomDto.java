package com.example.siemens.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private int id;
    private int roomNumber;
    private String type;
    private int price;
    private boolean isAvailable;
}
