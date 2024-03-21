package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOs.BookingRequestDTO;
import com.scaler.bookmyshow.DTOs.BookingResponseDTO;
import com.scaler.bookmyshow.Exceptions.ShowNotFoundException;
import com.scaler.bookmyshow.Exceptions.UserNotFoundException;
import com.scaler.bookmyshow.Exceptions.seatNotFoundException;
import com.scaler.bookmyshow.Models.Booking;
import com.scaler.bookmyshow.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    BookingResponseDTO bookTickets(BookingRequestDTO requestDTO) throws UserNotFoundException, ShowNotFoundException, seatNotFoundException {
        BookingResponseDTO responseDTO = new BookingResponseDTO();

        Booking booking = bookingService.book(requestDTO.getUserID(), requestDTO.getShowID() , requestDTO.getSeatsIDs());
        responseDTO.setBookingID(booking.getID());
        responseDTO.setBookingID(booking.getID());
        responseDTO.setAmount(booking.getAmount());

        return responseDTO;
    }
}
