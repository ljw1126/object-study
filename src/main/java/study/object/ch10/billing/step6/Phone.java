package study.object.ch10.billing.step6;

import study.object.ch09.money.Money;

import java.time.Duration;

public class Phone extends AbstractPhone {
    private Money amount; // 요금
    private Duration seconds; // 시간당

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    @Override
    protected Money calculateFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
