// AdditionalUser Mapper
package com.vereinsanmeldung.vereinsanmeldung.Mapper;

import com.vereinsanmeldung.vereinsanmeldung.Entities.AdditionalUserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdditionalUserMapper {
    public final static String ADDITIONAL_USER_SELECT = "SELECT * FROM additional_user";

    @Results(value = {
            @Result(property = "additionalUserId", column = "additional_user_id", id = true),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "userId", column = "user_id")
    })
    @Select(ADDITIONAL_USER_SELECT)
    List<AdditionalUserEntity> findAll();

    @Select(ADDITIONAL_USER_SELECT + " WHERE additional_user_id=#{additionalUserId}")
    AdditionalUserEntity readAdditionalUserById(@Param("additionalUserId") int additionalUserId);

    // Insert operation
    @Insert("INSERT INTO additional_user (first_name, last_name, birth_date, user_id) " +
            "VALUES (#{firstName}, #{lastName}, #{birthDate}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "additionalUserId")
    void insertAdditionalUser(AdditionalUserEntity additionalUser);

    // Update operation (all data except ID)
    @Update("UPDATE additional_user SET first_name=#{firstName}, last_name=#{lastName}, birth_date=#{birthDate}, user_id=#{userId} WHERE additional_user_id=#{additionalUserId}")
    void updateAdditionalUser(AdditionalUserEntity additionalUser);
}
