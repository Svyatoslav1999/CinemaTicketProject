package com.project.cinematicket.controller;

import com.project.cinematicket.dto.UserDTO;
import com.project.cinematicket.servise.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserServise userServise;

    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userServise.saveUser(userDTO);
    }

    @PutMapping("/update/{userId}")
    public UserDTO updateUserMoneyById(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO) {
        return userServise.updateUserMoneyById(userId, userDTO);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId) {
        userServise.deleteUserById(userId);
    }

    @GetMapping("/getAll")
    public List<UserDTO> findAllUsers(){
        return userServise.getAllUsers();
    }

    @PostMapping("/buyTicket/user/{userId}/session/{sessionId}/ticket/{seatNumber}")
    public UserDTO buyTicket(@PathVariable("userId") Long userId,
                             @PathVariable ("sessionId") Long sessionId,
                             @PathVariable("seatNumber") Long seatNumber) {

        return  userServise.buyTicket(userId, sessionId, seatNumber);
    }

}