// Subscription Service
package com.vereinsanmeldung.vereinsanmeldung.Services;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.SubscriptionDto;
import com.vereinsanmeldung.vereinsanmeldung.Entities.SubscriptionEntity;
import com.vereinsanmeldung.vereinsanmeldung.Mapper.SubscriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionMapper subscriptionMapper;

    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionMapper.findAll().stream()
                .map(SubscriptionMapper.INSTANCE::subscriptionEntityToDto)
                .collect(Collectors.toList());
    }

    public SubscriptionDto getSubscriptionById(int subscriptionId) {
        SubscriptionEntity subscriptionEntity = subscriptionMapper.readSubscriptionById(subscriptionId);
        return subscriptionEntity != null ? SubscriptionMapper.INSTANCE.subscriptionEntityToDto(subscriptionEntity) : null;
    }

    // Insert (Create) operation
    public SubscriptionDto createSubscription(SubscriptionDto subscriptionDto) {
        SubscriptionEntity subscriptionEntity = SubscriptionMapper.INSTANCE.subscriptionDtoToEntity(subscriptionDto);
        subscriptionMapper.insertSubscription(subscriptionEntity);
        return SubscriptionMapper.INSTANCE.subscriptionEntityToDto(subscriptionEntity);
    }

    // Update operation (all data except ID)
    public SubscriptionDto updateSubscription(int subscriptionId, SubscriptionDto subscriptionDto) {
        SubscriptionEntity subscriptionEntity = SubscriptionMapper.INSTANCE.subscriptionDtoToEntity(subscriptionDto);
        subscriptionEntity.setSubscriptionId(subscriptionId); // Make sure the ID remains the same
        subscriptionMapper.updateSubscription(subscriptionEntity);
        return SubscriptionMapper.INSTANCE.subscriptionEntityToDto(subscriptionEntity);
    }

    public void deleteSubscription(int subscriptionId) {
        subscriptionMapper.deleteSubscription(subscriptionId);
    }
}
