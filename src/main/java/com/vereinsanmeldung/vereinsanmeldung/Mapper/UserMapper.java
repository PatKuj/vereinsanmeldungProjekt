// User Mapper
package com.vereinsanmeldung.vereinsanmeldung.Mapper;


import com.vereinsanmeldung.vereinsanmeldung.Entities.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    public final static String USER_SELECT = "SELECT * FROM user";

    @Results(value = {
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "email", column = "email"),
            @Result(property = "city", column = "city"),
            @Result(property = "postalCode", column = "postal_code"),
            @Result(property = "confirmation", column = "confirmation"),
            @Result(property = "subscriptionId", column = "subscription_id")
    })
    @Select(USER_SELECT)
    List<UserEntity> findAll();

    @Select(USER_SELECT + " WHERE user_id=#{userId}")
    UserEntity readUserByUserId(@Param("userId") int userId);

    // Insert operation
    @Insert("INSERT INTO user (first_name, last_name, phone_number, birth_date, email, city, postal_code, confirmation, subscription_id) " +
            "VALUES (#{firstName}, #{lastName}, #{phoneNumber}, #{birthDate}, #{email}, #{city}, #{postalCode}, #{confirmation}, #{subscriptionId})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(UserEntity user);

    // Update operation (all data except ID)
    @Update("UPDATE user SET first_name=#{firstName}, last_name=#{lastName}, phone_number=#{phoneNumber}, birth_date=#{birthDate}, email=#{email}, city=#{city}, postal_code=#{postalCode}, confirmation=#{confirmation}, subscription_id=#{subscriptionId} WHERE user_id=#{userId}")
    void updateUser(UserEntity user);
}
