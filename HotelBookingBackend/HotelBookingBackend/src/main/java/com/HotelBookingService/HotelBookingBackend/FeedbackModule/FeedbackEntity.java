package com.HotelBookingService.HotelBookingBackend.FeedbackModule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FeedbackEntity {
    @Id
    @GeneratedValue
    private Long feedbackId;
}
