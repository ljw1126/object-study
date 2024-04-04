package study.object.ch11.billing.step5;

import study.object.ch11.money.Money;

import java.time.Duration;

public class TestApplication {
    public static void main(String[] args) {
        // 기본 요금
        Phone phone = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        // 심야 할인 요금
        Phone phone2 = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));

        // 기본 정책과 부가 정책 합성하기
        // 일반 요금 + 세금
        Phone phone3 = new Phone(
                new TaxablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)), 0.05)
        );

        // 일반 요금 + 기본 요금 할인 정책 + 세금 정책 조합
        // 데코레이터는 거꾸로 조합, 실행은 위에 순서대로
        Phone phone4 = new Phone(
                new TaxablePolicy(
                        new RateDiscountablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)), Money.wons(100)),
                        0.05
                )
        );

        // 세금 정책과 기본 요금 할인 정책을 바꾸고 싶은 경우 => 일반 요금 + 세금 정책 + 기본 요금 할인
        Phone phone5 = new Phone(
                new RateDiscountablePolicy(
                        new TaxablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)), 0.05),
                        Money.wons(100)
                )
        );

        // 동일한 정책을 심야 할인 요금에 적용 => 심야 요금 + 세금 정책 + 기본 요금 할인
        Phone phone6 = new Phone(
                new RateDiscountablePolicy(
                        new TaxablePolicy(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)), 0.05),
                        Money.wons(100)
                )
        );
    }
}
