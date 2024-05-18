package com.example.siemens.service;

import com.example.siemens.model.Hotel;

import java.util.List;

public interface HotelService {

    void saveHotel(Hotel hotel);
    void saveMoreHotels(List<Hotel> hotels);
    Hotel getById(int id);
    List<Hotel> getAll();
    List<Hotel> getByLatAndLong(double latitude, double longitude);
}
