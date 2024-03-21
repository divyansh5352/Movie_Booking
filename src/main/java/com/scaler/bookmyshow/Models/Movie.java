package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.Models.Enums.Features;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private List<Features> requiredFeatures;
}
