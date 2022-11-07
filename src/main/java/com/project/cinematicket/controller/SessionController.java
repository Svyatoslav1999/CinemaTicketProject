package com.project.cinematicket.controller;

import com.project.cinematicket.dto.SessionDTO;
import com.project.cinematicket.servise.SessionServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/session")
public class SessionController {
    private final SessionServise sessionServise;

    @PostMapping("/save")
    public SessionDTO saveSession(@RequestBody SessionDTO sessionDTO) {
        return sessionServise.saveSession(sessionDTO);
    }
}
