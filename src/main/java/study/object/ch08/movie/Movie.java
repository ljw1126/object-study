package study.object.ch08.movie;

import study.object.ch08.money.Money;
import study.object.ch08.movie.pricing.AmountDiscountPolicy;
import study.object.ch08.movie.pricing.SequenceCondition;

import java.time.Duration;

public class Movie {
    private String title; // 영화 제목
    private Duration runningTime; // 상영 시간
    private Money fee; // 비용

    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee) { // 부생성자 통해, 클라이언트에 편의성 제공
        this(title, runningTime, fee, new AmountDiscountPolicy(Money.wons(1000), new SequenceCondition(1), new SequenceCondition(10)));
    }

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return this.fee;
    }

    // DiscountPolicy 기본값이나, 외부에서 DiscountPolicy 주입할 수 있도록 하면 클라이언트의 사용성을 높일 수 있다
    public Money calculateMovieFeeDefault(Screening screening) {
        return calculateMovieFee(screening, new AmountDiscountPolicy(Money.wons(1000), new SequenceCondition(1), new SequenceCondition(10)));
    }

    public Money calculateMovieFee(Screening screening, DiscountPolicy discountPolicy) {
        Money discount = discountPolicy.isDiscountable(screening);
        return this.fee.minus(discount);
    }

    public Money calculateMovieFee(Screening screening) {
        return this.fee.minus(discountPolicy.isDiscountable(screening));
    }
}
