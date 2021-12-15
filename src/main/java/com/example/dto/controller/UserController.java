package com.example.dto.controller;

import com.example.dto.dto.UserRequestDTO;
import com.example.dto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * add a user getting request by another class this is called DTO (Data Transfer Object)
     * requested by UserRequestDTO with limited data
     * and also response with another class UserResponseDTO with limited no. of data
     * create entity with another class
     * @param userRequestDTO
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userRequestDTO){
        return  userService.addUser(userRequestDTO);
    }
}
