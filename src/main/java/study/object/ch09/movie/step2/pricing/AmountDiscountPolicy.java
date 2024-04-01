package study.object.ch09.movie.step2.pricing;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step2.DiscountCondition;
import study.object.ch09.movie.step2.DiscountPolicy;
import study.object.ch09.movie.step2.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return this.discountAmount;
    }
}
