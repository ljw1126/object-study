package study.object.ch08.movie.pricing;

import study.object.ch08.money.Money;
import study.object.ch08.movie.DiscountCondition;
import study.object.ch08.movie.DiscountPolicy;
import study.object.ch08.movie.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
