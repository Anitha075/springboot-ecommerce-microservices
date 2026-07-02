package com.app.ecom.Controller;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.service.UserService;
import com.app.ecom.model.Users;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequestMapping("api/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>getuser(@PathVariable Long id){
        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());


    }
    @PostMapping
    public ResponseEntity<String> CreateUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return ResponseEntity.ok("user added successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody UserRequest updatedUserRequest){
        boolean updated = userService.updateUser(id, updatedUserRequest);
        if(updated)
             return ResponseEntity.ok("user updated successfully");
        return ResponseEntity.notFound().build();
    }

}

//3:12