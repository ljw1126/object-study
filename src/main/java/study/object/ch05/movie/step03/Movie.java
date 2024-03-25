package study.object.ch05.movie.step03;

import study.object.ch04.money.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title; // 영화 제목
    private Duration runningTime; // 상영 시간
    private Money fee; // 비용
    private List<DiscountCondition> discountConditions; // 할인 조건

    private MovieType movieType; // 할인 정책 적용 여부
    private Money discountAmount; // 할인 금액
    private double discountPercent; // 할인 비율

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalArgumentException("");
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private boolean isDiscountable(Screening screening) {
        return this.discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
