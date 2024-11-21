// Erstellt DTO für die User-Klasse
package com.vereinsanmeldung.vereinsanmeldung.Dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record UserDto(
        int userId,
        String firstName,
        String lastName,
        String phoneNumber,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy") Date birthDate,
        String email,
        String city,
        String postalCode,
        Boolean confirmation,
        int subscriptionId
) {}