package study.object.ch08.movie;

import study.object.ch08.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public Money getMovieFee() {
        return this.movie.getFee();
    }

    public Money calculateMovieFee(int audienceCount) {
        return this.movie.calculateMovieFee(this).times(audienceCount);
    }
}
