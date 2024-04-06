package study.object.ch14.billing.step02;

import study.object.ch14.time.DateTimeInterval;

import java.util.List;

public interface FeeCondition {
    List<DateTimeInterval> findTimeInterval(Call call);
}
