// Mapper-Klasse für BankDetails
package com.vereinsanmeldung.vereinsanmeldung.Mapper;

import com.vereinsanmeldung.vereinsanmeldung.Entities.BankDetailsEntity;
import com.vereinsanmeldung.vereinsanmeldung.Dtos.BankDetailsDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankDetailsMapper {
    public final static String BANK_DETAILS_SELECT = "SELECT * FROM bank_details";

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
    List<BankDetailsEntity> findAll();

    @Select(BANK_DETAILS_SELECT + " WHERE bank_id=#{bankId}")
    BankDetailsEntity readBankDetailsById(@Param("bankId") int bankId);

    // Insert operation
    @Insert("INSERT INTO bank_details (first_name, last_name, bic, bank_name, iban, user_id) " +
            "VALUES (#{firstName}, #{lastName}, #{bic}, #{bankName}, #{iban}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "bankId")
    void insertBankDetails(BankDetailsEntity bankDetails);

    // Update operation
    @Update("UPDATE bank_details SET first_name=#{firstName}, last_name=#{lastName}, bic=#{bic}, bank_name=#{bankName}, iban=#{iban}, user_id=#{userId} WHERE bank_id=#{bankId}")
    void updateBankDetails(BankDetailsEntity bankDetails);

    // Delete operation by bank ID
    @Delete("DELETE FROM bank_details WHERE bank_id=#{bankId}")
    void deleteBankDetails(@Param("bankId") int bankId);

    // Delete operation by user ID (neue Methode)
    @Delete("DELETE FROM bank_details WHERE user_id=#{userId}")
    void deleteBankDetailsByUserId(@Param("userId") int userId);

    // Mapping methods
    BankDetailsDto bankDetailsEntityToDto(BankDetailsEntity entity);
    BankDetailsEntity bankDetailsDtoToEntity(BankDetailsDto dto);
}
