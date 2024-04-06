package study.object.ch14.billing.step02;

import study.object.ch14.time.DateTimeInterval;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 시간대별 요금제
 * 예)
 * 00시 ~ 19시까지 10초당 18원
 * 19시 ~ 24시까지 10초당 15원
 * <p>
 * 1월1일 10시 ~ 1월 3일 15시까지 통화했다고 했을때
 * - splitByDay()는 1/1 10시 ~ 24시, 1/2일 0시 ~ 24시, 1/3일 0시 ~ 15시 정보 반환한다
 */
public class TimeOfDayFeeCondition implements FeeCondition {
    private LocalTime from;
    private LocalTime to;

    public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    // TODO 이해 안됨..
    @Override
    public List<DateTimeInterval> findTimeInterval(Call call) {
        return call.splitByDay()
                .stream()
                .filter(each -> from(each).isBefore(to(each)))
                .map(each -> DateTimeInterval.of(
                                LocalDateTime.of(each.getFrom().toLocalDate(), from(each)),
                                LocalDateTime.of(each.getTo().toLocalDate(), to(each))
                        )
                ).collect(Collectors.toList());
    }

    /**
     * 시간대별 정책이 아래와 같고
     * 00시 ~ 19시까지 10초당 18원
     * 19시 ~ 24시까지 10초당 15원
     * <p>
     * 통화를 1월1일 10시 ~ 1월 3일 15시까지 했을때
     * <p>
     * from : 00시, to : 19시, duration : 10초당, money : 18원
     * from : 19시, to : 24시, duration : 10초당, money : 15원
     */
    private LocalTime from(DateTimeInterval interval) {
        return interval.getFrom().toLocalTime().isBefore(from) ? from : interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval) {
        return interval.getTo().toLocalTime().isAfter(to) ? to : interval.getTo().toLocalTime();
    }
}
