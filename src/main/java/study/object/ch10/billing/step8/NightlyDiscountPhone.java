package study.object.ch10.billing.step8;

import study.object.ch09.money.Money;

import java.time.Duration;

/**
 * 심야 할인 요금제
 * - LATE_NIGHT_HOUR 기준
 * 1) 이전에는 10초당 5원
 * 2) 이후에는 10초당 2원
 * <p>
 * p364 추상화를 통한 중복 제거
 */
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPhone(double taxRate, Money nightlyAmount, Money regularAmount, Duration seconds) {
        super(taxRate);
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) { // 심야 할인 요금
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }

        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

}
