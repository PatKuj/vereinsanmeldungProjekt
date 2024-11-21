// Erstellt DTO für die Subscription-Klasse
package com.vereinsanmeldung.vereinsanmeldung.Dtos;

import java.math.BigDecimal;

public record SubscriptionDto(
        int subscriptionId,
        String group,
        String sportType,
        String duration,
        BigDecimal subFee
) {}
