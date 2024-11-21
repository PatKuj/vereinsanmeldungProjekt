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

    public List<AdditionalUserDto> getAllAdditionalUsers() {
        return additionalUserMapper.findAll().stream()
                .map(AdditionalUserMapper.INSTANCE::additionalUserEntityToDto)
                .collect(Collectors.toList());
    }

    public AdditionalUserDto getAdditionalUserById(int additionalUserId) {
        AdditionalUserEntity additionalUserEntity = additionalUserMapper.readAdditionalUserById(additionalUserId);
        return additionalUserEntity != null ? AdditionalUserMapper.INSTANCE.additionalUserEntityToDto(additionalUserEntity) : null;
    }

    // Insert (Create) operation
    public AdditionalUserDto createAdditionalUser(AdditionalUserDto additionalUserDto) {
        AdditionalUserEntity additionalUserEntity = AdditionalUserMapper.INSTANCE.additionalUserDtoToEntity(additionalUserDto);
        additionalUserMapper.insertAdditionalUser(additionalUserEntity);
        return AdditionalUserMapper.INSTANCE.additionalUserEntityToDto(additionalUserEntity);
    }

    // Update operation (all data except ID)
    public AdditionalUserDto updateAdditionalUser(int additionalUserId, AdditionalUserDto additionalUserDto) {
        AdditionalUserEntity additionalUserEntity = AdditionalUserMapper.INSTANCE.additionalUserDtoToEntity(additionalUserDto);
        additionalUserEntity.setAdditionalUserId(additionalUserId); // Make sure the ID remains the same
        additionalUserMapper.updateAdditionalUser(additionalUserEntity);
        return AdditionalUserMapper.INSTANCE.additionalUserEntityToDto(additionalUserEntity);
    }

    public void deleteAdditionalUser(int additionalUserId) {
        additionalUserMapper.deleteAdditionalUser(additionalUserId);
    }
}
