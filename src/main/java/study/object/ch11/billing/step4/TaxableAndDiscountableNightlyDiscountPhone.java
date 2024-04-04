package study.object.ch11.billing.step4;

import study.object.ch11.money.Money;

import java.time.Duration;

// 심야 요금 + 세금 정책 + 기본 요금 할인 정책
public class TaxableAndDiscountableNightlyDiscountPhone extends RateDiscountableNightlyDiscountPhone {
    private Money discountAmount;

    public TaxableAndDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount, Money discountAmount1) {
        super(nightlyAmount, regularAmount, seconds, discountAmount);
        this.discountAmount = discountAmount1;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
