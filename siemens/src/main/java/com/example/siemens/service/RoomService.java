package com.example.siemens.service;

import com.example.siemens.model.Room;
import com.example.siemens.model.dto.RoomDto;

import java.util.List;

public interface RoomService {

    List<RoomDto> findRoomsAvailable(int hotel_id);
    Room findById(int id);
    Room update(int id);
}
