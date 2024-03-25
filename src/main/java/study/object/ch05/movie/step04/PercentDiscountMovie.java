package study.object.ch05.movie.step04;


import study.object.ch05.money.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
    private final double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
