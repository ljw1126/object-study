package study.object.ch09.movie.step1.client;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step1.Movie;
import study.object.ch09.movie.step1.pricing.AmountDiscountPolicy;
import study.object.ch09.movie.step1.pricing.SequenceCondition;

import java.time.Duration;

public class Client {
    public Money getAvatarFee() {
        // 결합도가 높고 재사용성이 낮은
        Movie avatar = new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10)
                )
        );

        return avatar.getFee();
    }
}
