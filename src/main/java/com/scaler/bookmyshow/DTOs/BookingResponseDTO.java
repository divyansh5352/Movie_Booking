package com.scaler.bookmyshow.DTOs;

import com.scaler.bookmyshow.Models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {
    private Booking booking;
    private Long BookingID;
    private int amount;
}
