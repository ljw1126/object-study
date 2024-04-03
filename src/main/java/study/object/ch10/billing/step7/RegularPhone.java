package study.object.ch10.billing.step7;

import study.object.ch09.money.Money;

import java.time.Duration;

// 의도를 드러내는 이름 선택하기 (클래스명만 변경)
public class RegularPhone extends Phone {
    private Money amount; // 요금
    private Duration seconds; // 시간당

    public RegularPhone(Money amount, Duration seconds) {
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
