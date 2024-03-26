package study.object.ch05.movie.step05;

import java.time.DayOfWeek;
import java.time.LocalTime;

// 할인 조건 : 순번/기간 조건 둘 다 가짐, 타입으로 구분
public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence; // 상영 순번

    private DayOfWeek dayOfWeek; // 요일
    private LocalTime startTime; // 시작 시간
    private LocalTime endTime; // 종료 시간

    public DiscountCondition(int sequence) {
        this.type = DiscountConditionType.SEQUENCE;
        this.sequence = sequence;
    }

    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.type = DiscountConditionType.PERIOD;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isDiscountable(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    public boolean isSatisfiedByPeriod(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    public boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

    public DiscountConditionType getType() {
        return type;
    }

    public int getSequence() {
        return sequence;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
