package com.example.siemens.service;

import com.example.siemens.model.dto.RoomDto;
import com.example.siemens.model.Room;
import com.example.siemens.model.Hotel;
import com.example.siemens.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImp implements RoomService{

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelService hotelService;

    @Override
    public Room findById(int id){
        return roomRepository.findById(id);
    }

    @Override
    public Room update(int id){
        return roomRepository.save(roomRepository.findById(id)) ;
    }
    @Override
    public List<RoomDto> findRoomsAvailable(int hotel_id) {
        Hotel hotel = hotelService.getById(hotel_id);
        return hotel.getRooms().stream().map(Room::toDTO).collect(Collectors.toList());
    }
}
