package study.object.ch14.billing.step02;

import study.object.ch14.time.DateTimeInterval;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 구간별 방식
 * - 초기 A분 동안 B초당 C원
 * - A분 ~ D분까지 B초당 D원
 * - D분 초과시 B초당 E원
 */
public class DurationFeeCondition implements FeeCondition {
    private Duration from;
    private Duration to;

    public DurationFeeCondition(Duration from, Duration to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeInterval(Call call) {
        if (call.getInterval().duration().compareTo(from) < 0) { // 초기 from분 미만인 경우
            return Collections.emptyList();
        }

        // 통화시간 중에 from ~ to 사이의 시간에 대해서만 요금 계산한다는 명제인듯
        DateTimeInterval interval = call.getInterval();
        return Arrays.asList(DateTimeInterval.of(
                interval.getFrom().plus(from),
                interval.duration().compareTo(to) > 0 ? interval.getFrom().plus(to) : interval.getTo()
        ));
    }
}
