package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.Models.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    private String TransactionID;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
    @OneToOne
    private Booking booking;
}
