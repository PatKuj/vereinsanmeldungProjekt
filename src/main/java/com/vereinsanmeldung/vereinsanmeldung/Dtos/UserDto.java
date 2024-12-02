// Erstellt DTO für die User-Klasse
package com.vereinsanmeldung.vereinsanmeldung.Dtos;

import java.util.Date;
import java.util.List;
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
        int subscriptionId,
        List<AdditionalUserDto> additionalUserDtos,
        BankDetailsDto bankDetailsDto
) {
    // Getter für additionalUserDtos
    public List<AdditionalUserDto> getAdditionalUserDtos() {
        return additionalUserDtos;
    }

    // Getter für bankDetailsDto
    public BankDetailsDto getBankDetailsDto() {
        return bankDetailsDto;
    }

    // Setter-ähnliche Methode für userId in BankDetailsDto
    public UserDto withBankDetailsDto(BankDetailsDto newBankDetailsDto) {
        return new UserDto(userId, firstName, lastName, phoneNumber, birthDate, email, city, postalCode, confirmation, subscriptionId, additionalUserDtos, newBankDetailsDto);
    }

    // Setter-ähnliche Methode für AdditionalUserDtos
    public UserDto withAdditionalUserDtos(List<AdditionalUserDto> newAdditionalUserDtos) {
        return new UserDto(userId, firstName, lastName, phoneNumber, birthDate, email, city, postalCode, confirmation, subscriptionId, newAdditionalUserDtos, bankDetailsDto);
    }

    // Setter-ähnliche Methode für confirmation
    public UserDto withConfirmation(Boolean newConfirmation) {
        return new UserDto(userId, firstName, lastName, phoneNumber, birthDate, email, city, postalCode, newConfirmation, subscriptionId, additionalUserDtos, bankDetailsDto);
    }
}
