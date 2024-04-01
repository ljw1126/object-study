package study.object.ch09.movie.step2.pricing;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step2.DiscountCondition;
import study.object.ch09.movie.step2.DiscountPolicy;
import study.object.ch09.movie.step2.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
