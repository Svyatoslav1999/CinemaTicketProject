package com.project.cinematicket.servise.impl;

import com.project.cinematicket.dto.UserDTO;
import com.project.cinematicket.entity.SessionEntity;
import com.project.cinematicket.entity.TicketEntity;
import com.project.cinematicket.entity.UserEntity;
import com.project.cinematicket.mapper.UserMapper;
import com.project.cinematicket.repository.SessionRepository;
import com.project.cinematicket.repository.TicketRepository;
import com.project.cinematicket.repository.UserRepository;
import com.project.cinematicket.servise.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSeriveImpl implements UserServise {

    private final UserMapper userMapper;

private final SessionRepository sessionRepository;
private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.mapDTOtoEntity(userDTO);
        userRepository.saveAndFlush(userEntity);
        return userMapper.mapEntityToDTO(userEntity);
    }

    @Override
    public UserDTO updateUserMoneyById(Long id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found");
        });
        userMapper.updateUserMoney(userEntity, userDTO);
        userRepository.saveAndFlush(userEntity);
        return userMapper.mapEntityToDTO(userEntity);
    }

    @Override
    public void deleteUserById(Long id) {
   UserEntity userEntity = userRepository.findById(id).orElseThrow(() ->{
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   });
   userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = userMapper.mapToDTOList(userEntities);
        return userDTOS;
    }

    @Override
    public UserDTO buyTicket(Long userId, Long sessionId, Long seatNumber) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        TicketEntity ticketEntity = ticketRepository.findBySeatNumber(seatNumber);

        if (ticketEntity.getReserved()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        double newMoneyBalance;
        if (userEntity.getMoneyBalance() < sessionEntity.getTicketPrice()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            newMoneyBalance = userEntity.getMoneyBalance() - sessionEntity.getTicketPrice();
        }
        ticketEntity.setUser(userEntity);
        ticketEntity.setReserved(true);
        userEntity.setMoneyBalance(newMoneyBalance);
        ticketRepository.saveAndFlush(ticketEntity);
        userRepository.saveAndFlush(userEntity);
        return null;

    }

}

