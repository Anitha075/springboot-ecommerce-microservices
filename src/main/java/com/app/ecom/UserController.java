package com.app.ecom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<Users> usersList=new ArrayList<>();

    @GetMapping("/api/users")
    public List<Users> getAllUsers(){
        return usersList ;
    }
}
