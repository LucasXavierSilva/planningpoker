package com.br.planningpoker.service;

import com.br.planningpoker.dto.UserDTO;
import com.br.planningpoker.entity.User;
import com.br.planningpoker.exception.PlanningPokerException;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO) throws PlanningPokerException;

    UserDTO findUserDTOById(Long id) throws PlanningPokerException;

    User findUserById(Long id) throws PlanningPokerException;
}
