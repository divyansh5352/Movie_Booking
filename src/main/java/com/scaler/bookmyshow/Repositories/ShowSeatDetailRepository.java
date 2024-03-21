package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatDetailRepository extends JpaRepository<ShowSeatDetail,Long> {
    List<ShowSeatDetail>findAllByShow(Show show);
}
