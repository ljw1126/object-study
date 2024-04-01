package study.object.ch09.movie.step2.client;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step2.Movie;
import study.object.ch09.movie.step2.pricing.AmountDiscountPolicy;
import study.object.ch09.movie.step2.pricing.SequenceCondition;

import java.time.Duration;

public class Factory {
    public Movie createAvatarMovie() {
        return new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10)
                )
        );
    }
}
