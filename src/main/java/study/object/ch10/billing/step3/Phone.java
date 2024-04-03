package study.object.ch10.billing.step3;

import study.object.ch09.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * p346
 * 타입 코드를 사용하여 두 클래스를 하나로 합칠 수 있다
 * 하지만 낮은 응집도와 높은 결합도라는 문제는 여전하다
 */
public class Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    enum PhoneType {REGULAR, NIGHTLY}

    private PhoneType type;

    private Money amount; // 초당 요금
    private Money regularAmount; // 일반 요금
    private Money nightlyAmount; // 심야 요금
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money regularAmount, Money nightlyAmount, Duration seconds) {
        this(PhoneType.NIGHTLY, Money.ZERO, regularAmount, nightlyAmount, seconds);
    }

    public Phone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (type == PhoneType.REGULAR) { // 일반 요금
                result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else { // 심야 요금
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }

        return result; // 세금은 어떻게 ??
    }
}
