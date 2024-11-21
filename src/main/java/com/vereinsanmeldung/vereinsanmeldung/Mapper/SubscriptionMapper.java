// Subscription Mapper
package com.vereinsanmeldung.vereinsanmeldung.Mapper;

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
}
