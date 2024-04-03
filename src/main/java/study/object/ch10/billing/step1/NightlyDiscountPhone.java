package study.object.ch10.billing.step1;

import study.object.ch09.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 심야 할인 요금제
 * - LATE_NIGHT_HOUR 기준
 * 1) 이전에는 10초당 5원
 * 2) 이후에는 10초당 2원
 * <p>
 * Phone 클래스와 거의 동일 (중복)
 */
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) { // 심야 할인 요금
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else { // 일반 요금
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result;
    }

}
