package study.object.ch11.billing.step2;

import study.object.ch11.money.Money;

import java.time.Duration;

public class RegularPhone extends Phone {
    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return this.amount.times(call.getDuration().getSeconds() / seconds.getSeconds()); // 요금 * (총 통화시간 / 기준 초)
    }
}
