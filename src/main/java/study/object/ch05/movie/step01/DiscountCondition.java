package study.object.ch05.movie.step01;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

// 할인 조건 : 순번/기간 조건 둘 다 가짐, 타입으로 구분
public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence; // 상영 순번

    private DayOfWeek dayOfWeek; // 요일
    private LocalTime startTime; // 시작 시간
    private LocalTime endTime; // 종료 시간

    public DiscountConditionType getType() {
        return type;
    }

    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    public boolean isSatisfiedByPeriod(Screening screening) {
        LocalDateTime whenScreened = screening.getWhenScreened();
        return this.dayOfWeek.equals(whenScreened.getDayOfWeek())
                && this.startTime.compareTo(whenScreened.toLocalTime()) <= 0
                && this.endTime.compareTo(whenScreened.toLocalTime()) >= 0;
    }

    public boolean isSatisfiedBySequence(Screening screening) {
        return this.sequence == screening.getSequence();
    }
}
