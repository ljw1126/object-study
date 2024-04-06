package study.object.ch14.billing.step01;

import study.object.ch14.money.Money;
import study.object.ch14.time.DateTimeInterval;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 시간대별 방식
 * 예)
 * 00시 ~ 19시까지 10초당 18원
 * 19시 ~ 24시까지 10초당 15원
 * <p>
 * 1월1일 10시 ~ 1월 3일 15시까지 통화했다고 했을때
 * - splitByDay()는 1/1 10시 ~ 24시, 1/2일 0시 ~ 24시, 1/3일 0시 ~ 15시 정보 반환한다
 */
public class TimeOfDayDiscountPolicy extends BasicRatePolicy {
    private List<LocalTime> starts = new ArrayList<>(); // 시작 시간
    private List<LocalTime> ends = new ArrayList<>(); // 종료 시간
    private List<Duration> durations = new ArrayList<>(); // 단위 시간 (초당)
    private List<Money> amounts = new ArrayList<>(); // 비용 (초당)

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;

        for (DateTimeInterval interval : call.splitByDay()) {
            for (int loop = 0; loop < starts.size(); loop++) {
                // 비용 * (총 통화시간 / 단위 시간)
                result.plus(
                        amounts.get(loop).times(
                                Duration.between(from(interval, starts.get(loop)), to(interval, ends.get(loop))).getSeconds()
                                        / durations.get(loop).getSeconds()
                        )
                );
            }
        }

        return result;
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
    private LocalTime from(DateTimeInterval interval, LocalTime from) {
        return interval.getFrom().toLocalTime().isBefore(from) ? from : interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval, LocalTime to) {
        return interval.getTo().toLocalTime().isAfter(to) ? to : interval.getTo().toLocalTime();
    }
}
