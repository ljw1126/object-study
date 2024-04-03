package study.object.ch10.billing.step1;

import study.object.ch09.money.Money;

import java.time.Duration;
import java.time.LocalDateTime;

public class BilingApplication {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10)); // 10초당 5원
        //1분씩 통화
        phone.call(
                new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
                        LocalDateTime.of(2018, 1, 1, 12, 11, 0))
        );
        phone.call(
                new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
                        LocalDateTime.of(2018, 1, 2, 12, 11, 0))
        );

        Money money = phone.calculateFee();
        assert money.equals(Money.wons(60));
    }
}
