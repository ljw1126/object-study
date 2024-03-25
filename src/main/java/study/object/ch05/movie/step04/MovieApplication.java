package study.object.ch05.movie.step04;

import study.object.ch05.money.Money;

import java.time.Duration;

public class MovieApplication {
    public static void main(String[] args) {
        Movie movie = new AmountDiscountMovie(
                "타이타닉",
                Duration.ofMinutes(120),
                Money.wons(10000),
                Money.wons(1000),
                new SequenceCondition(1), new SequenceCondition(10)
        );
    }
}
