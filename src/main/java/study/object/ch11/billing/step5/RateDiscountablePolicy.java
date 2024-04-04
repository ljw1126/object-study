package study.object.ch11.billing.step5;

import study.object.ch11.money.Money;

// 요금 할인
public class RateDiscountablePolicy extends AdditionalRatePolicy {
    private Money discountAmount;

    public RateDiscountablePolicy(RatePolicy policy, Money discountAmount) {
        super(policy);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
