package study.object.ch11.billing.step5;

import study.object.ch11.money.Money;

// 세금 정책
public class TaxablePolicy extends AdditionalRatePolicy {

    private double taxRate;

    public TaxablePolicy(RatePolicy policy, double taxRate) {
        super(policy);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
