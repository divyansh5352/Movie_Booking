package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.Models.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatDetail extends BaseModel{
    @OneToOne
    private Show show;
    private SeatType seatType;
    private int Price;
}
