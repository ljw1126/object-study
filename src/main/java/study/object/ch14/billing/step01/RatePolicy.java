package study.object.ch14.billing.step01;

import study.object.ch14.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
