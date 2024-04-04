package study.object.ch11.billing.step5;

import study.object.ch11.money.Money;

import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {
    private Money amount; // 요금
    private Duration seconds; // 초

    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
