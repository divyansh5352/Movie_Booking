package com.scaler.bookmyshow.Models;

import jakarta.persistence.OneToMany;

import java.util.List;

public class City extends BaseModel{
    private  String name;
    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
}
