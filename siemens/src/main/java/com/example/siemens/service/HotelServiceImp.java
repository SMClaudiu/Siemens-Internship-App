package com.example.siemens.service;

import com.example.siemens.model.Hotel;
import com.example.siemens.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel getById(int id) {
        return hotelRepository.findById(id);
    }

    @Override
    public void saveMoreHotels(List<Hotel> hotels){
        hotelRepository.saveAll(hotels);
    }
    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getByLatAndLong(double latitute, double longitude) {
        // de verificat formula
        return null;
    }
}
