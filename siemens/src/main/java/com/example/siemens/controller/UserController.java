package com.example.siemens.controller;

import com.example.siemens.model.Room;
import com.example.siemens.model.User;
import com.example.siemens.model.dto.RoomDto;
import com.example.siemens.model.dto.UserDto;
import com.example.siemens.service.RoomService;
import com.example.siemens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    //http://localhost:8080/users/reservation/1/1?name="test"&phone="testPhone"
    @PostMapping("/reservation/{hotelId}/{roomId}")
    public void makeReservation(@PathVariable int hotelId, @PathVariable int roomId, @RequestParam String name, String phone) {
        LocalDateTime now = LocalDateTime.now();
        User user = userService.getByNameAndPhone(name, phone);

        Room room = roomService.findById(roomId);
        room.setReservationDate(now);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setPhoneNumber(phone);
            user.setFeedback("");
            user.setReservedRooms(new ArrayList<>());
            userService.addUser(user);
        }

        List<Room> reservedRooms = user.getReservedRooms();
        if (reservedRooms == null) {
            reservedRooms = new ArrayList<>();
        }
        reservedRooms.add(room);
        user.setReservedRooms(reservedRooms);
        room.setAvailable(false);
        roomService.update(room.getId());
        userService.updateUser(user);
    }


    @GetMapping("/getReservations/{userId}")
    public User getReservations(@PathVariable int userId){
        return userService.getReservations(userId);
    }

    @DeleteMapping("removeByName")
    public void removeUser(@PathVariable String name){
        userService.removeUser(name);
    }

}
