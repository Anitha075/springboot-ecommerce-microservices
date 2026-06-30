package com.app.ecom.service;

import com.app.ecom.Repository.UserRepository;
import com.app.ecom.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
   // private List<Users> usersList = new ArrayList<>();



    public List<Users> fetchAllUsers() {

        return userRepository.findAll();
    }



    public void addUser(Users user) {
        userRepository.save(user);
    }


    public Optional<Users> fetchUserById(Long id) {
        return userRepository.findById(id);
    }
    public boolean updateUser(Long id,Users updatedUser)
    {
        return userRepository.findById(id)
                .map(existingUser->{
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);
    }
}






