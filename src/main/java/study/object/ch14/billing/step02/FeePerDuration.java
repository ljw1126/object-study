package study.object.ch14.billing.step02;

import study.object.ch14.money.Money;
import study.object.ch14.time.DateTimeInterval;

import java.time.Duration;

public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval) {
        return fee.times(Math.ceil((double) interval.duration().getNano() / duration.toNanos())); // 단위 시간당 요금
    }
}
