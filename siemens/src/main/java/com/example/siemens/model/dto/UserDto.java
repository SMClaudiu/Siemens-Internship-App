package com.example.siemens.model.dto;

import com.example.siemens.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String phoneNumber;
    private List<Room> roomList;
    private LocalDateTime now;
}
