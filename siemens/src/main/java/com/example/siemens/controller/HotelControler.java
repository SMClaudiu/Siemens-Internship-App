package com.example.siemens.controller;

import com.example.siemens.model.Hotel;
import com.example.siemens.model.Room;
import com.example.siemens.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelControler {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/getAll")
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Hotel hotel){
        hotelService.saveHotel(hotel);
    }

    @PostMapping("/addMore")
    public void addMoreHotels(@RequestBody List<Hotel> hotels){
        hotelService.saveMoreHotels(hotels);
    }
}