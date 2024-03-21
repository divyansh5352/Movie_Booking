package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeat;
import com.scaler.bookmyshow.Models.ShowSeatDetail;
import com.scaler.bookmyshow.Repositories.ShowSeatDetailRepository;
import com.scaler.bookmyshow.Repositories.ShowSeatRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {
    private ShowSeatDetailRepository showSeatDetailRepository;

    @Autowired
    public PriceCalculator(ShowSeatDetailRepository showSeatDetailRepository) {
        this.showSeatDetailRepository = showSeatDetailRepository;
    }

    public int calculatePrice(Show show , List<ShowSeat> seats){
        List<ShowSeatDetail> showSeatDetails = showSeatDetailRepository.findAllByShow(show);
        int totalAmount = 0;

        for ( ShowSeat showSeat : seats){
            for ( ShowSeatDetail showSeatDetail : showSeatDetails){
                if ( showSeat.getSeat().getSeatType().equals(showSeatDetail.getSeatType())){
                    totalAmount+=showSeatDetail.getPrice();
                }
            }
        }
        return totalAmount;
    }
}
