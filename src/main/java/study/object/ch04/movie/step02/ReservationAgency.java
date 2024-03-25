package study.object.ch04.movie.step02;

import study.object.ch04.money.Money;

/**
 * 영화 예매
 * - p150 ~ 154 리팩토링
 */
public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
