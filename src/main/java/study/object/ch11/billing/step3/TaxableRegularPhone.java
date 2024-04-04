package study.object.ch11.billing.step3;

import study.object.ch11.money.Money;

import java.time.Duration;

// 일반 요금(기본) + 세금 (부가)
public class TaxableRegularPhone extends RegularPhone {
    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money money) {
        return money.plus(money.times(taxRate));
    }
}
