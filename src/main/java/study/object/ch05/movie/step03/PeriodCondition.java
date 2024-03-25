package study.object.ch05.movie.step03;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek; // 요일
    private LocalTime startTime; // 시작 시간
    private LocalTime endTime; // 종료 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        LocalDateTime whenScreened = screening.getWhenScreened();
        return this.dayOfWeek.equals(whenScreened.getDayOfWeek())
                && this.startTime.compareTo(whenScreened.toLocalTime()) <= 0
                && this.endTime.compareTo(whenScreened.toLocalTime()) >= 0;
    }
}
