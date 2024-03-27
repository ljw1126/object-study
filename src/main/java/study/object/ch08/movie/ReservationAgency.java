package study.object.ch08.movie;

import study.object.ch08.money.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateMovieFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
