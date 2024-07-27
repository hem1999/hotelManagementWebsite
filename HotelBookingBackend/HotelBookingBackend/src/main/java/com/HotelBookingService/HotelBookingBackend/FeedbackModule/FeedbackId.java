package com.HotelBookingService.HotelBookingBackend.FeedbackModule;

import java.io.Serializable;
import java.util.Objects;

public class FeedbackId implements Serializable {

    private Long userId;
    private Long roomId;

    public FeedbackId() {

    }

    public FeedbackId(Long userId, Long roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackId f = (FeedbackId) o;
        return Objects.equals(userId, f.userId) && Objects.equals(roomId, f.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roomId);
    }

}
