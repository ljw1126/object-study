package study.object.ch11.billing.step5;

import study.object.ch11.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy policy;

    protected AdditionalRatePolicy(RatePolicy policy) {
        this.policy = policy;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = policy.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
