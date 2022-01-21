package com.br.planningpoker.service.impl;

import com.br.planningpoker.converter.UserConverter;
import com.br.planningpoker.dto.UserDTO;
import com.br.planningpoker.entity.User;
import com.br.planningpoker.exception.PlanningPokerException;
import com.br.planningpoker.repository.UserRepository;
import com.br.planningpoker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Saves a new {@link  User}.
     *
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO saveUser(UserDTO userDTO) throws PlanningPokerException {
        validateUser(userDTO);
        UserConverter userConverter = new UserConverter();
        User user = userConverter.userDTOToUser(userDTO);
        userRepository.save(user);
        return userConverter.userToUserDTO(user);
    }

    /**
     * Find {@link UserDTO} according to it's id.
     *
     * @param id
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public UserDTO findUserDTOById(Long id) throws PlanningPokerException {
        UserConverter userConverter = new UserConverter();
        return userConverter.userToUserDTO(findUserById(id));
    }

    /**
     * Find {@link User} according to it's id.
     *
     * @param id
     * @return
     * @throws PlanningPokerException
     */
    @Override
    public User findUserById(Long id) throws PlanningPokerException {
        if(id == null) {
            return null;
        }
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new PlanningPokerException("User could not be found");
        }
        return user.get();
    }

    /**
     * Validates the {@link UserDTO}.
     *
     * @param userDTO
     * @throws PlanningPokerException
     */
    private void validateUser(UserDTO userDTO) throws PlanningPokerException {
        if(userDTO == null) {
            throw new PlanningPokerException("User is invalid.");
        }
        if(!StringUtils.hasLength(userDTO.getNickname())) {
            throw new PlanningPokerException("User name/nickname cannot be empty");
        }
    }
}
