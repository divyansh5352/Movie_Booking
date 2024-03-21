package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.Models.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int row;
    private int col;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
