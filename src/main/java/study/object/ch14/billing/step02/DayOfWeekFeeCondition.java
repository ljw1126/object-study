package study.object.ch14.billing.step02;

import study.object.ch14.time.DateTimeInterval;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 요일별 기본 요금제 조건
 */
public class DayOfWeekFeeCondition implements FeeCondition {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();

    public DayOfWeekFeeCondition(DayOfWeek... dayOfWeeks) {
        this.dayOfWeeks = Arrays.asList(dayOfWeeks);
    }

    @Override
    public List<DateTimeInterval> findTimeInterval(Call call) {
        return call.splitByDay()
                .stream()
                .filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
                .collect(Collectors.toList());
    }
}
