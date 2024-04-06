package study.object.ch14.billing.step02;

import study.object.ch14.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
