// Subscription Mapper
package com.vereinsanmeldung.vereinsanmeldung.Mapper;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.SubscriptionDto;
import com.vereinsanmeldung.vereinsanmeldung.Entities.SubscriptionEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubscriptionMapper {
    public final static String SUBSCRIPTION_SELECT = "SELECT * FROM subscription";

    @Results(value = {
            @Result(property = "subscriptionId", column = "subscription_id", id = true),
            @Result(property = "group", column = "group"),
            @Result(property = "sportType", column = "sport_type"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "subFee", column = "sub_fee")
    })
    @Select(SUBSCRIPTION_SELECT)
    List<SubscriptionEntity> findAll();

    @Select(SUBSCRIPTION_SELECT + " WHERE subscription_id=#{subscriptionId}")
    SubscriptionEntity readSubscriptionById(@Param("subscriptionId") int subscriptionId);

    // Insert operation
    @Insert("INSERT INTO subscription (group, sport_type, duration, sub_fee) " +
            "VALUES (#{group}, #{sportType}, #{duration}, #{subFee})")
    @Options(useGeneratedKeys = true, keyProperty = "subscriptionId")
    void insertSubscription(SubscriptionEntity subscription);

    // Update operation (all data except ID)
    @Update("UPDATE subscription SET group=#{group}, sport_type=#{sportType}, duration=#{duration}, sub_fee=#{subFee} WHERE subscription_id=#{subscriptionId}")
    void updateSubscription(SubscriptionEntity subscription);

    // Delete operation
    @Delete("DELETE FROM subscription WHERE subscription_id=#{subscriptionId}")
    void deleteSubscription(@Param("subscriptionId") int subscriptionId);

    // Mapping methods
    SubscriptionDto subscriptionEntityToDto(SubscriptionEntity entity);
    SubscriptionEntity subscriptionDtoToEntity(SubscriptionDto dto);
}
