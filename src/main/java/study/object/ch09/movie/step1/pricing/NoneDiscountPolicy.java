package study.object.ch09.movie.step1.pricing;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step1.DiscountCondition;
import study.object.ch09.movie.step1.DiscountPolicy;
import study.object.ch09.movie.step1.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
