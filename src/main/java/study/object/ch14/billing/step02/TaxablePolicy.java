package study.object.ch14.billing.step02;

import study.object.ch14.billing.step01.AdditionalRatePolicy;
import study.object.ch14.billing.step01.RatePolicy;
import study.object.ch14.money.Money;

//부가 정책 - 세금
public class TaxablePolicy extends AdditionalRatePolicy {
    private double taxRate;

    public TaxablePolicy(RatePolicy next, double taxRate) {
        super(next);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
