// Erstellt Entity für die Subscription-Tabelle
package com.vereinsanmeldung.vereinsanmeldung.Entities;

import java.math.BigDecimal;

public class SubscriptionEntity {
    private int subscriptionId;
    private String group;
    private String sportType;
    private String duration;
    private BigDecimal subFee;

    // Getter and Setter methods
    public int getSubscriptionId() {
        return subscriptionId;
    }
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getSportType() {
        return sportType;
    }
    public void setSportType(String sportType) {
        this.sportType = sportType;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public BigDecimal getSubFee() {
        return subFee;
    }
    public void setSubFee(BigDecimal subFee) {
        this.subFee = subFee;
    }

    @Override
    public String toString() {
        return "SubscriptionEntity{" +
                "subscriptionId=" + subscriptionId +
                ", group='" + group + '\'' +
                ", sportType='" + sportType + '\'' +
                ", duration='" + duration + '\'' +
                ", subFee=" + subFee +
                '}';
    }
}
