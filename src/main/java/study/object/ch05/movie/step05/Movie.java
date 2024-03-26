package study.object.ch05.movie.step05;

import study.object.ch05.money.Money;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title; // 영화 제목
    private Duration runningTime; // 상영 시간
    private Money fee; // 비용
    private List<DiscountCondition> discountConditions; // 할인 조건

    private MovieType movieType; // 할인 정책 적용 여부
    private Money discountAmount; // 할인 금액
    private double discountPercent; // 할인 비율

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(
            List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
