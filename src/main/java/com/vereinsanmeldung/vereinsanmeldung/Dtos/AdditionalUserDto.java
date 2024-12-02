// Erstellt DTO für die AdditionalUser-Klasse
package com.vereinsanmeldung.vereinsanmeldung.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public record AdditionalUserDto(
        int additionalUserId,
        String firstName,
        String lastName,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy") Date birthDate,
        int userId
) {
    // Setter für userId
    public AdditionalUserDto withUserId(int userId) {
        return new AdditionalUserDto(additionalUserId, firstName, lastName, birthDate, userId);
    }
}