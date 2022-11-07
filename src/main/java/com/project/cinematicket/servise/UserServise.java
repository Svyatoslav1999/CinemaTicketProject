package com.project.cinematicket.servise;

import com.project.cinematicket.dto.UserDTO;

import java.util.List;

public interface UserServise {
    UserDTO saveUser(UserDTO userDTO);


    UserDTO updateUserMoneyById(Long id, UserDTO userDTO);

    void deleteUserById(Long id);

    List<UserDTO> getAllUsers ();

    UserDTO buyTicket(Long userId, Long sessionId, Long seatNumber);


}
