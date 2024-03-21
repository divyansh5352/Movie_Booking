package com.scaler.bookmyshow.Models;

import java.util.List;

public class Theatre extends BaseModel{
    private String name;
    private City city;
    private List<Auditorium> auditoriums;
}
