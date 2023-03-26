package Interfaces;

import Models.Rate;

public interface RatingInterface {
    public void updateRating(Rate rate);

    public Double fetchRating(Rate rate);

    public Double fetchRatingAVG(Rate rate);
}
