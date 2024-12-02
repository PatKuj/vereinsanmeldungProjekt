// User Mapper
package com.vereinsanmeldung.vereinsanmeldung.Mapper;

import com.vereinsanmeldung.vereinsanmeldung.Entities.UserEntity;
import com.vereinsanmeldung.vereinsanmeldung.Entities.AdditionalUserEntity;
import com.vereinsanmeldung.vereinsanmeldung.Entities.BankDetailsEntity;
import com.vereinsanmeldung.vereinsanmeldung.Dtos.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    public final static String USER_SELECT = "SELECT * FROM user";
    public final static String ADDITIONAL_USER_SELECT = "SELECT * FROM additional_user WHERE user_id = #{userId}";
    public final static String BANK_DETAILS_SELECT = "SELECT * FROM bank_details WHERE user_id = #{userId}";

    @Results(id = "userResultMap", value = {
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "email", column = "email"),
            @Result(property = "city", column = "city"),
            @Result(property = "postalCode", column = "postal_code"),
            @Result(property = "confirmation", column = "confirmation"),
            @Result(property = "subscriptionId", column = "subscription_id"),
            @Result(property = "additionalUsers", column = "user_id",
                    javaType = List.class,
                    many = @Many(select = "com.vereinsanmeldung.vereinsanmeldung.Mapper.UserMapper.findAdditionalUsersByUserId")),
            @Result(property = "bankDetails", column = "user_id",
                    javaType = BankDetailsEntity.class,
                    one = @One(select = "com.vereinsanmeldung.vereinsanmeldung.Mapper.UserMapper.findBankDetailsByUserId"))
    })
    @Select(USER_SELECT)
    List<UserEntity> findAll();

    @Select(USER_SELECT + " WHERE user_id=#{userId}")
    @ResultMap("userResultMap")
    UserEntity readUserByUserId(@Param("userId") int userId);

    // Insert operation
    @Insert("INSERT INTO user (first_name, last_name, phone_number, birth_date, email, city, postal_code, confirmation, subscription_id) " +
            "VALUES (#{firstName}, #{lastName}, #{phoneNumber}, #{birthDate}, #{email}, #{city}, #{postalCode}, #{confirmation}, #{subscriptionId})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(UserEntity user);

    // Update operation (all data except ID)
    @Update("UPDATE user SET first_name=#{firstName}, last_name=#{lastName}, phone_number=#{phoneNumber}, birth_date=#{birthDate}, email=#{email}, city=#{city}, postal_code=#{postalCode}, confirmation=#{confirmation}, subscription_id=#{subscriptionId} WHERE user_id=#{userId}")
    void updateUser(UserEntity user);

    // Delete operation
    @Delete("DELETE FROM user WHERE user_id=#{userId}")
    void deleteUser(@Param("userId") int userId);

    // Method to find additional users by userId
    @Results(value = {
            @Result(property = "additionalUserId", column = "additional_user_id", id = true),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "userId", column = "user_id")
    })
    @Select(ADDITIONAL_USER_SELECT)
    List<AdditionalUserEntity> findAdditionalUsersByUserId(@Param("userId") int userId);

    // Method to find bank details by userId
    @Results(value = {
            @Result(property = "bankId", column = "bank_id", id = true),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "bic", column = "bic"),
            @Result(property = "bankName", column = "bank_name"),
            @Result(property = "iban", column = "iban"),
            @Result(property = "userId", column = "user_id")
    })
    @Select(BANK_DETAILS_SELECT)
    BankDetailsEntity findBankDetailsByUserId(@Param("userId") int userId);

    // Mapping methods
    UserDto userEntityToUserDto(UserEntity entity);
    UserEntity userDtoToUserEntity(UserDto dto);
}
