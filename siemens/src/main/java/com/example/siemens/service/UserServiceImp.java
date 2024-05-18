    package com.example.siemens.service;

    import com.example.siemens.model.User;
    import com.example.siemens.model.dto.UserDto;
    import com.example.siemens.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class UserServiceImp implements UserService{

        @Autowired
        private UserRepository userRepository;

        @Override
        public void addUser(User user){
            userRepository.save(user);
        }

        @Override
        public void updateUser(User user){
            userRepository.save(user);
        }

        @Override
        public User getByNameAndPhone(String name, String phone){
            return userRepository.findByNameAndPhoneNumber(name, phone);
        }
        @Override
        public void removeUser(String name){
            userRepository.removeUserByName(name);
        }

        @Override
        public User getReservations(int id){
            return userRepository.findById(id);
        }
    }
