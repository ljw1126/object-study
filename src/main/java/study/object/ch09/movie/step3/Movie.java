package study.object.ch09.movie.step3;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step3.locator.ServiceLocator;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        // 숨겨진 의존성 문제, Movie 생성시 ServiceLocator 설정하지 않으면 null이 주입되어서 런타임 에러 발생
        // 의도를 드러내지 않기 때문에 사용하려면 클래스 구현 내부를 샅샅히 뒤져야 함
        this.discountPolicy = ServiceLocator.discountPolicy();
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
