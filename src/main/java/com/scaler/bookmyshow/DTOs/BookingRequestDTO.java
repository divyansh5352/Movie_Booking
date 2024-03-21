package com.scaler.bookmyshow.DTOs;

import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeat;
import com.scaler.bookmyshow.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookingRequestDTO {
    private Long userID;
    private Long showID;
    private List<Long> seatsIDs;
}
