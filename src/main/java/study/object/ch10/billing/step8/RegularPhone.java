package study.object.ch10.billing.step8;

import study.object.ch09.money.Money;

import java.time.Duration;

// 부모 클래스의 속성 추가에 따른 자식 클래스 생성자 변경은 피할 수 없는 트레이드 오프
public class RegularPhone extends Phone {
    private Money amount; // 요금
    private Duration seconds; // 시간당

    public RegularPhone(double taxRate, Money amount, Duration seconds) {
        super(taxRate);
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
