package study.object.ch08.movie.pricing;

import study.object.ch08.money.Money;
import study.object.ch08.movie.DiscountCondition;
import study.object.ch08.movie.DiscountPolicy;
import study.object.ch08.movie.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    public NoneDiscountPolicy(DiscountCondition... discountConditions) {
        super(discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
