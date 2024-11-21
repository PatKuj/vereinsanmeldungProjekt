// Controller-Klasse für Subscription-Endpoints
package com.vereinsanmeldung.vereinsanmeldung.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vereinsanmeldung.vereinsanmeldung.Dtos.SubscriptionDto;
import com.vereinsanmeldung.vereinsanmeldung.Services.SubscriptionService;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{subscriptionId}")
    public SubscriptionDto getSubscriptionById(@PathVariable int subscriptionId) {
        return subscriptionService.getSubscriptionById(subscriptionId);
    }

    @PostMapping
    public SubscriptionDto createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.createSubscription(subscriptionDto);
    }

    @PutMapping("/{subscriptionId}")
    public SubscriptionDto updateSubscription(@PathVariable int subscriptionId, @RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.updateSubscription(subscriptionId, subscriptionDto);
    }

    @DeleteMapping("/{subscriptionId}")
    public void deleteSubscription(@PathVariable int subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }
}
