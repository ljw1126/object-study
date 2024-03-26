package study.object.ch05.movie.step04;

import study.object.ch05.money.Money;

import java.time.Duration;

public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
