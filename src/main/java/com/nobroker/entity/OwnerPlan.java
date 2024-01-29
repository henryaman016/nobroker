package com.nobroker.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "owner_plan")
@Data
public class OwnerPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adjust the strategy based on your database and requirements
    @Column(name = "owner_plan_id")
    private long ownerPlanId;

    @Column(name = "user_id" , unique = true)
    private long userId;

    @Column(name = "subscription_active")
    private boolean subscriptionActive;

    @Column(name = "subscription_active_date")
    private LocalDate subscriptionActiveDate;

    @Column(name = "subscription_expiration_date")
    private LocalDate subscriptionExpirationDate;

    @Column(name = "number_of_days")
    private int numberOfDays;
}
