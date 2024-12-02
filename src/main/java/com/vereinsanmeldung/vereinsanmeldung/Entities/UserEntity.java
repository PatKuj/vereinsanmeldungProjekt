// Erstellt Entity für die User-Tabelle
package com.vereinsanmeldung.vereinsanmeldung.Entities;

import java.util.Date;
import java.util.List;

public class UserEntity {
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birthDate;
    private String email;
    private String city;
    private String postalCode;
    private Boolean confirmation;
    private int subscriptionId;

    // Neue Felder für zusätzliche Benutzer und BankDetails
    private List<AdditionalUserEntity> additionalUsers;
    private BankDetailsEntity bankDetails;

    // Getter and Setter methods
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public Boolean getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }
    public int getSubscriptionId() {
        return subscriptionId;
    }
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    // Getter and Setter for AdditionalUsers
    public List<AdditionalUserEntity> getAdditionalUsers() {
        return additionalUsers;
    }
    public void setAdditionalUsers(List<AdditionalUserEntity> additionalUsers) {
        this.additionalUsers = additionalUsers;
    }

    // Getter and Setter for BankDetails
    public BankDetailsEntity getBankDetails() {
        return bankDetails;
    }
    public void setBankDetails(BankDetailsEntity bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", confirmation=" + confirmation +
                ", subscriptionId=" + subscriptionId +
                ", additionalUsers=" + additionalUsers +
                ", bankDetails=" + bankDetails +
                '}';
    }
}
