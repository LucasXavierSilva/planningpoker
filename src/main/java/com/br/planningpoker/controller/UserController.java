package com.br.planningpoker.controller;

import com.br.planningpoker.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO);

    ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long id);
}
