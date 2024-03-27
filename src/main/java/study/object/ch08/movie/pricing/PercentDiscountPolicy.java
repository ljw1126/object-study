package study.object.ch08.movie.pricing;

import study.object.ch08.money.Money;
import study.object.ch08.movie.DiscountCondition;
import study.object.ch08.movie.DiscountPolicy;
import study.object.ch08.movie.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
