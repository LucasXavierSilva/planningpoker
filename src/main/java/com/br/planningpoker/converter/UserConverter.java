package com.br.planningpoker.converter;

import com.br.planningpoker.dto.UserDTO;
import com.br.planningpoker.entity.User;

public class UserConverter {

    /**
     * Converts {@link  UserDTO} to {@link User}.
     *
     * @param userDTO
     * @return
     */
    public User userDTOToUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        User user = new User();

        user.setId(userDTO.getId());
        user.setNickname(userDTO.getNickname());

        return user;
    }

    /**
     * Converts {@link  User} to {@link UserDTO}.
     *
     * @param user
     * @return
     */
    public UserDTO userToUserDTO(User user) {
        if(user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setNickname(user.getNickname());
        return userDTO;
    }
}
