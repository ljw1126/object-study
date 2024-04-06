package study.object.ch14.billing.step01;

import study.object.ch14.money.Money;

import java.time.Duration;

/**
 * 구간별 방식
 * - 초기 A분 동안 B초당 C원
 * - A분 ~ D분까지 B초당 D원
 * - D분 초과시 B초당 E원
 * <p>
 * 기본 요금제마다 구현이 다르다 보니 이해하기 어렵다 ..
 * <p>
 * 코드 재사용을 위한 상속은 해롭다 (p518)
 */
public class DurationDiscountRule extends FixedFeePolicy {
    private Duration from;
    private Duration to;

    public DurationDiscountRule(Money amount, Duration seconds, Duration from, Duration to) {
        super(amount, seconds); // 초당 요금
        this.from = from;
        this.to = to;
    }

    public Money calculate(Call call) {
        // 총 통화시간이 to보다 큰 경우 -- to 이후에도 0원으로 가정한듯
        if (call.getDuration().compareTo(to) > 0) {
            return Money.ZERO;
        }

        // 총 통화시간이 from보다 작은 경우 -- 초기 from 전까지는 0원
        if (call.getDuration().compareTo(from) < 0) {
            return Money.ZERO;
        }

        //부모 메소드 호출할 때 데이터 전달 용도로 만든 임시 객체
        //**통화시간 중에 from ~ to 사이의 시간에 대해서만 요금 계산한다는 명제인듯
        Phone phone = new Phone();
        phone.call(new Call(
                call.getFrom().plus(from),
                call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo()
        ));

        return super.calculateCallFee(call); // 부모 클래스와 강결합
    }

}
