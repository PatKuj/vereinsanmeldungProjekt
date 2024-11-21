// Service-Klasse für die User-Logik
package com.vereinsanmeldung.vereinsanmeldung.Services;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.UserDto;
import com.vereinsanmeldung.vereinsanmeldung.Entities.UserEntity;
import com.vereinsanmeldung.vereinsanmeldung.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userMapper.findAll().stream()
                .map(UserMapper.INSTANCE::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(int userId) {
        UserEntity userEntity = userMapper.readUserByUserId(userId);
        return userEntity != null ? UserMapper.INSTANCE.userEntityToUserDto(userEntity) : null;
    }

    // Insert (Create) operation
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(userDto);
        userMapper.insertUser(userEntity);
        return UserMapper.INSTANCE.userEntityToUserDto(userEntity);
    }

    // Update operation (all data except ID)
    public UserDto updateUser(int userId, UserDto userDto) {
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(userDto);
        userEntity.setUserId(userId); // Make sure the ID remains the same
        userMapper.updateUser(userEntity);
        return UserMapper.INSTANCE.userEntityToUserDto(userEntity);
    }

    public void deleteUser(int userId) {
        userMapper.deleteUser(userId);
    }
}
