// Erstellt DTO für die BankDetails-Klasse
package com.vereinsanmeldung.vereinsanmeldung.Dtos;

public record BankDetailsDto(
        int bankId,
        String firstName,
        String lastName,
        String bic,
        String bankName,
        String iban,
        int userId
) {
    // Setter für userId
    public BankDetailsDto withUserId(int userId) {
        return new BankDetailsDto(bankId, firstName, lastName, bic, bankName, iban, userId);
    }
}
