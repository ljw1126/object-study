package study.object.ch10.billing.step4;

import study.object.ch09.money.Money;
import study.object.ch10.billing.step2.Call;

import java.time.Duration;

/**
 * p348
 * - 상속을 이용해서 중복 코드 제거하기
 * - 심야 할인 기준 전에는 부모 클래스 Phone에서 처리하도록 함
 * <p>
 * 개발자는 재사용을 위해 상속 계층 사이에 무수히 많은 가정을 세웠을지 모른다.
 * 그리고 그 가정은 코드를 이해하기 어렵게 만들뿐만 아니라 직관에도 어긋날 수 있다
 * ..요구사항과 구현 사이의 차이가 크면 클수록 코드를 이해하기 어려워진다.
 * 잘못된 상속은 이 차이를 더 크게 벌린다
 */
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money regularAmount, Duration seconds, Money nightlyAmount) {
        super(regularAmount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    /**
     * 1) 일반 요금으로 전체 계산 (5원)
     * 2) 심야 요금(2원)으로 계산하는데 (일반 요금 - 심야요금 = 3원) 차에 대해서 구함
     * <p>
     * 일반 요금으로 더해진 심야 통화는 3원 더 비싸게 받아서 차이를 구하면 결과를 구할 수 있다
     */
    @Override
    public Money calculateFee() {
        // 부모 클래스의 calculateFee 호출
        Money money = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        getAmount().minus(nightlyAmount).times(call.getDuration().getSeconds() / getSeconds().getSeconds())
                );
            }
        }

        return money.minus(nightlyFee);
    }
}
