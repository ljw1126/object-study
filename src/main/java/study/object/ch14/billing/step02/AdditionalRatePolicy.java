package study.object.ch14.billing.step02;

import study.object.ch14.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy next;

    protected AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
