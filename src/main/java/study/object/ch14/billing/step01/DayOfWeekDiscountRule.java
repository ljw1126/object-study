package study.object.ch14.billing.step01;


import study.object.ch14.money.Money;
import study.object.ch14.time.DateTimeInterval;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 요일별 기본 요금제에서 요일별 요금에 대한 클래스
 */
public class DayOfWeekDiscountRule {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private Duration duration = Duration.ZERO;
    private Money amount = Money.ZERO;

    public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
        this.dayOfWeeks = dayOfWeeks;
        this.duration = duration;
        this.amount = amount;
    }

    public Money calculate(DateTimeInterval interval) {
        if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
            return amount.times((double) interval.duration().getSeconds() / duration.getSeconds());
        }

        return Money.ZERO;
    }

}
