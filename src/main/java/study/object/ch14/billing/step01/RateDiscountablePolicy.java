package study.object.ch14.billing.step01;

import study.object.ch14.money.Money;

// 부가 정책 - 요금 할인
public class RateDiscountablePolicy extends AdditionalRatePolicy {
    private Money discountAmount;

    public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
