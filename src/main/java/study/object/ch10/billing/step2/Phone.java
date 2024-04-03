package study.object.ch10.billing.step2;

import study.object.ch09.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 추가 요구 사항
 * - 세금 계산 추가
 */
public class Phone {
    private Money amount; // 요금
    private Duration seconds; // 시간당
    private List<Call> calls = new ArrayList<>();
    private double taxRate; // 세금

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds())); // 비용 * 총 시간(초)
        }

        return result.plus(result.times(taxRate)); // 총 비용 * 세금비율을 추가로 더해준다
    }
}
