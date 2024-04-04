package study.object.ch11.billing.step4;

import study.object.ch11.money.Money;

import java.time.Duration;

// 기본 요금 + 세금 정책 + 기본 요금 할인 정책
public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {
    private Money discountAmount;

    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money money) {
        return super.afterCalculated(money).minus(discountAmount); // 세금 적용 후 기본 요금 할인
    }
}
