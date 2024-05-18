package com.example.siemens.repository;

import com.example.siemens.model.Room;
import com.example.siemens.model.dto.RoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {


    Room findById(int id);
}
