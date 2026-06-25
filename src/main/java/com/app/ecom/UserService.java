package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private List<Users> usersList = new ArrayList<>();



    public List<Users> fetchAllUsers() {

        return usersList;
    }



    public List<Users> addUser(Users user) {
        usersList.add(user);
        return usersList;
    }


    public Optional<Users> fetchUserById(Long id) {
        return usersList.stream()
                .filter(users -> users.getId().equals(id))
                .findFirst();
    }
    public boolean updateUser(Long id,Users updatedUser)
    {
        return  usersList.stream()
                .filter(users -> users.getId().equals(id))
                .findFirst()
                .map(existingUser->{
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);
    }
}






