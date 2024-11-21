// Erstellt Entity für die BankDetails-Tabelle
package com.vereinsanmeldung.vereinsanmeldung.Entities;

public class BankDetailsEntity {
    private int bankId;
    private String firstName;
    private String lastName;
    private String bic;
    private String bankName;
    private String iban;
    private int userId;

    // Getter and Setter methods
    public int getBankId() {
        return bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBic() {
        return bic;
    }
    public void setBic(String bic) {
        this.bic = bic;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BankDetailsEntity{" +
                "bankId=" + bankId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bic='" + bic + '\'' +
                ", bankName='" + bankName + '\'' +
                ", iban='" + iban + '\'' +
                ", userId=" + userId +
                '}';
    }
}
