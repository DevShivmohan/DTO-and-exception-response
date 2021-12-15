package com.example.dto.service;

import com.example.dto.dao.UserRepo;
import com.example.dto.dto.UserRequestDTO;
import com.example.dto.dto.UserResponseDTO;
import com.example.dto.entity.User;
import com.example.dto.exception.SomeTechnicalProblemException;
import com.example.dto.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserResponseDTO userResponseDTO;

    /**
     * add a user when email already exist then throw an exception
     * @param userRequestDTO
     * @return
     */
    public ResponseEntity<?> addUser(UserRequestDTO userRequestDTO){
            List<User> users=userRepo.findAllUser();
            for(User user:users)
                if(user.getEmail().equalsIgnoreCase(userRequestDTO.getEmail()))
                    throw new UserAlreadyExistException("User record already exist in our database");
            User user=new User();
            user.setName(userRequestDTO.getName());
            user.setEmail(userRequestDTO.getEmail());
            user.setPassword(userRequestDTO.getPassword());
            user.setCaptureDate(LocalDateTime.now());
            user=userRepo.save(user);
            if(user!=null){
                userResponseDTO.setName(user.getName());
                userResponseDTO.setEmail(user.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
            }
            else
                throw new SomeTechnicalProblemException("Due to some technical problem request cannot be processed");
    }
}
