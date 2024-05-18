package com.example.siemens.repository;

import com.example.siemens.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Override
    List<Hotel> findAll();

    List<Hotel> findByLatitudeAndAndLongitude(double latitude, double longitude);
    Hotel findById(int id);
}
