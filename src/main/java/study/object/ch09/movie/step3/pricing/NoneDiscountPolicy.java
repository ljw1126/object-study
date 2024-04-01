package study.object.ch09.movie.step3.pricing;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step3.DiscountCondition;
import study.object.ch09.movie.step3.DiscountPolicy;
import study.object.ch09.movie.step3.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
