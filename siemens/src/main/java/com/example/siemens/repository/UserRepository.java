package com.example.siemens.repository;

import com.example.siemens.model.User;
import com.example.siemens.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    void removeUserByName(String name);

    User findByName(String name);
    User findById(int id);
    User findByNameAndPhoneNumber(String name, String phoneNumber);
}
