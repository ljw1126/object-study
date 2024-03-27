package study.object.ch08.movie.pricing;

import study.object.ch08.movie.DiscountCondition;
import study.object.ch08.movie.Screening;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 의존성 전이(p286)
 * PeriodCondition이 Screening에 의존하면
 * Screening이 의존하는 LocalDateTime whenScreened에 대해서도
 * PeriodCondition이 간접 의존하게 된다 (indirect dependency)
 */
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
        return whenScreened.getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(whenScreened.toLocalTime()) <= 0 &&
                endTime.compareTo(whenScreened.toLocalTime()) >= 0;
    }
}
