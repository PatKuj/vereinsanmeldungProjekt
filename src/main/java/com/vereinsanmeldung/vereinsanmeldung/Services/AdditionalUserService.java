// AdditionalUser Service
package com.vereinsanmeldung.vereinsanmeldung.Services;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.AdditionalUserDto;
import com.vereinsanmeldung.vereinsanmeldung.Mapper.AdditionalUserMapper;
import com.vereinsanmeldung.vereinsanmeldung.Entities.AdditionalUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdditionalUserService {

    @Autowired
    private AdditionalUserMapper additionalUserMapper;

    // Get all additional users
    public List<AdditionalUserDto> getAllAdditionalUsers() {
        List<AdditionalUserEntity> entities = additionalUserMapper.findAll();
        return entities.stream()
                .map(additionalUserMapper::additionalUserEntityToDto)
                .collect(Collectors.toList());
    }

    // Get additional users by user ID
    public List<AdditionalUserDto> getAdditionalUsersByUserId(int userId) {
        List<AdditionalUserEntity> entities = additionalUserMapper.findAll()  // You may need a dedicated query for finding by userId
                .stream()
                .filter(entity -> entity.getUserId() == userId)
                .collect(Collectors.toList());
        return entities.stream()
                .map(additionalUserMapper::additionalUserEntityToDto)
                .collect(Collectors.toList());
    }

    // Get additional user by ID
    public AdditionalUserDto getAdditionalUserById(int additionalUserId) {
        AdditionalUserEntity entity = additionalUserMapper.readAdditionalUserById(additionalUserId);
        return additionalUserMapper.additionalUserEntityToDto(entity);
    }

    // Create a new additional user
    public AdditionalUserDto createAdditionalUser(AdditionalUserDto additionalUserDto) {
        AdditionalUserEntity entity = additionalUserMapper.additionalUserDtoToEntity(additionalUserDto);
        additionalUserMapper.insertAdditionalUser(entity);
        return additionalUserMapper.additionalUserEntityToDto(entity);
    }

    // Update additional user
    public AdditionalUserDto updateAdditionalUser(int additionalUserId, AdditionalUserDto additionalUserDto) {
        AdditionalUserEntity entity = additionalUserMapper.additionalUserDtoToEntity(additionalUserDto);
        entity.setAdditionalUserId(additionalUserId);
        additionalUserMapper.updateAdditionalUser(entity);
        return additionalUserMapper.additionalUserEntityToDto(entity);
    }

    // Delete additional user
    public void deleteAdditionalUser(int additionalUserId) {
        additionalUserMapper.deleteAdditionalUser(additionalUserId);
    }
}
