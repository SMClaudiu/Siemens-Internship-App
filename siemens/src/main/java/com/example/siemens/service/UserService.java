package com.example.siemens.service;

import com.example.siemens.model.User;
import com.example.siemens.model.dto.UserDto;


public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void removeUser(String name);
    User getReservations(int id);
    User getByNameAndPhone(String name, String phone);
}
