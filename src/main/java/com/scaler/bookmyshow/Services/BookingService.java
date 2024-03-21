package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Exceptions.ShowNotFoundException;
import com.scaler.bookmyshow.Exceptions.UserNotFoundException;
import com.scaler.bookmyshow.Exceptions.seatNotFoundException;
import com.scaler.bookmyshow.Models.Booking;
import com.scaler.bookmyshow.Models.Enums.ShowSeatStatus;
import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeat;
import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Repositories.ShowRepository;
import com.scaler.bookmyshow.Repositories.ShowSeatRepository;
import com.scaler.bookmyshow.Repositories.UserRepository;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculator priceCalculator;
@Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, PriceCalculator priceCalculator) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculator = priceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking book(Long userID , Long ShowID ,List<Long> seatIds ) throws UserNotFoundException, ShowNotFoundException, seatNotFoundException {

        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("User Not found");
        }
        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findByID(ShowID);
        if ( optionalShow.isEmpty()){
            throw new ShowNotFoundException("Show not found");
        }
        Show Bookedshow = optionalShow.get();

        List<ShowSeat> seats = showSeatRepository.findAllByID(seatIds);

        for ( ShowSeat seat : seats){
            if ( !seat.getStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new seatNotFoundException( "Seat not available , try again ");
            }
        }

        List<ShowSeat>savedSeats = new ArrayList<>();
        for ( ShowSeat seat : seats){
            seat.setStatus(ShowSeatStatus.LOCKED);
            savedSeats.add(seat);
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(savedSeats);
        booking.setAmount(priceCalculator.calculatePrice(Bookedshow,savedSeats));
        booking.setCreatedAt(new Date());
        booking.setUpdatedAt(new Date());
        return booking;
    }
}
