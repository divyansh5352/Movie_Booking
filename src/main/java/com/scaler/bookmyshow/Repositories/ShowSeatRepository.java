package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat>findAllByID(List<Long>ShowSeatIDs);
    ShowSeat save(ShowSeat showSeat);
}
