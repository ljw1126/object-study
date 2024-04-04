package study.object.ch11.billing.step2;

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
    public Money calculateFee() { // Phone(추상)의 구현 메서드
        Money fee = super.calculateFee(); // 자식이 부모 호출하면서 결합도 높아짐
        return fee.plus(fee.times(taxRate));
    }
}
