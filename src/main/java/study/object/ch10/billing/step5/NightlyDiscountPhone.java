package study.object.ch10.billing.step5;

import study.object.ch09.money.Money;
import study.object.ch10.billing.step2.Call;

import java.time.Duration;

/**
 * p352
 * 상속을 위한 경고1
 * - 자식 클래스의 메서드 안에서 super 참졸르 이용해 부모 클래스의 메서드를 직접 호출할 경우 두 클래스는 강하게 결합된다
 * super 호출을 제거할 수 있는 방법을 찾아 결합도를 제거하라
 * <p>
 * 세금 계산이 추가할 경우
 * Phone도 변경해야 하고, NightlyDiscountPhone도 생성자 변경해야 한다
 * -> 다시 말해 코드 중복을 제거하기 위해 상속을 사용했음에도 세금을 계산하는 로직을 추가하기 위해 새로운 중복 코드를 만들어야 하는 것이다
 */
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money regularAmount, Duration seconds, double taxRate, Money nightlyAmount) {
        super(regularAmount, seconds, taxRate);
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

        return money.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
    }
}
