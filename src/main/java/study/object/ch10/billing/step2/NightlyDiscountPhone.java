package study.object.ch10.billing.step2;

import study.object.ch09.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 추가 요구 사항
 * - 세금 계산 추가
 */
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) { // 심야 할인 요금
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())); // 심야 요금 * (총 통화 시간(초) / 기준 (초))
            } else { // 일반 요금
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result.minus(result.times(taxRate)); // 총 비용 * 세금 비율을 빼준다 **
    }

}
