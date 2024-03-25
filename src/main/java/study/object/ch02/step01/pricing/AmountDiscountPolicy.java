package study.object.ch02.step01.pricing;

import study.object.ch02.money.Money;
import study.object.ch02.step01.DiscountCondition;
import study.object.ch02.step01.DiscountPolicy;
import study.object.ch02.step01.Screening;

// 요금 할인
public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
