package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
    Optional<Show> findByID( Long ID);
}
