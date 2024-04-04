package study.object.ch11.billing.step5;

import study.object.ch11.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
