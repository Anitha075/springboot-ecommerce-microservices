package com.app.ecom;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    @GetMapping("/api/users")
    public ResponseEntity<List<Users>> getAllUsers(){

        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<Users>getuser(@PathVariable Long id){
        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());


    }
    @PostMapping("api/users")
    public ResponseEntity<String> CreateUser(@RequestBody Users user){
        userService.addUser(user);
        return ResponseEntity.ok("user added successfully");
    }
    @PutMapping("api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody Users updatedUser){
        boolean updated = userService.updateUser(id, updatedUser);
        if(updated)
             return ResponseEntity.ok("user updated successfully");
        return ResponseEntity.notFound().build();
    }

}

