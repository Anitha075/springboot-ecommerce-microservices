package com.app.ecom;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;



@Data
public class Users {


    private Long id;
    private String firstName;
    private String lastName;

}
