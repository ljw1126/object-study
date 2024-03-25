package study.object.ch02.step01;

import study.object.ch02.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreended;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreended) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreended = whenScreended;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public LocalDateTime getStartTime() {
        return whenScreended;
    }

    public Reservation reverse(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
