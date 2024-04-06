package study.object.ch14.billing.step01;

import study.object.ch14.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone); // 기본 요금제(=종료조건)을 계싼 후 부가 정책을 처리한다
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
