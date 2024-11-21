// Erstellt Entity für die AdditionalUser-Tabelle
package com.vereinsanmeldung.vereinsanmeldung.Entities;

import java.util.Date;

public class AdditionalUserEntity {
    private int additionalUserId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int userId;

    // Getter and Setter methods
    public int getAdditionalUserId() {
        return additionalUserId;
    }
    public void setAdditionalUserId(int additionalUserId) {
        this.additionalUserId = additionalUserId;
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
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AdditionalUserEntity{" +
                "additionalUserId=" + additionalUserId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", userId=" + userId +
                '}';
    }
}
