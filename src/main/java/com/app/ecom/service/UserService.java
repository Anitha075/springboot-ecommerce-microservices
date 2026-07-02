package com.app.ecom.service;

import com.app.ecom.Repository.UserRepository;
import com.app.ecom.dto.AddressDTO;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;



    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapUserResponse)
                .collect(Collectors.toList());
    }



    public void addUser(UserRequest userRequest) {


        Users users=new Users();
        updateUserFromRequest(users,userRequest);
        userRepository.save(users);
    }

    private void updateUserFromRequest(Users user, UserRequest userRequest) {

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());

        if (userRequest.getAddress() != null) {


            Address address = user.getAddress();
            if (address == null) {
                address = new Address();
            }
            address.setStreet(userRequest.getAddress().getStreet());
            address.setCity(userRequest.getAddress().getCity());
            address.setState(userRequest.getAddress().getState());
            address.setCountry(userRequest.getAddress().getCountry());
            address.setZipcode(userRequest.getAddress().getZipcode());
           user.setAddress(address);
        }
    }


    public Optional<UserResponse> fetchUserById(Long id) {

        return userRepository.findById(id)
                .map(this::mapUserResponse);
    }
    public boolean updateUser(Long id,UserRequest updateUserRequest)
    {
        return userRepository.findById(id)
                .map(existingUser->{
                   updateUserFromRequest(existingUser,updateUserRequest);
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);
    }
    private UserResponse mapUserResponse(Users user) {

        UserResponse response = new UserResponse();

        response.setId(String.valueOf(user.getId()));
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());

        if (user.getAddress() != null) {

            AddressDTO  addressDTO = new AddressDTO();

            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setState(user.getAddress().getState());
            addressDTO.setCountry(user.getAddress().getCountry());
            addressDTO.setZipcode(user.getAddress().getZipcode());

            response.setAddress(addressDTO);
        }

        return response;
    }
}






