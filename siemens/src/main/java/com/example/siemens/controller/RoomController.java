package com.example.siemens.controller;


import com.example.siemens.model.dto.RoomDto;
import com.example.siemens.service.RoomService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getAvailable/{hotel_id}")
    public List<RoomDto> getAvailableRooms(@PathVariable int hotel_id){
        return roomService.findRoomsAvailable(hotel_id);
    }
}
