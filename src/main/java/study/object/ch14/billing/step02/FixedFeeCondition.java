package study.object.ch14.billing.step02;

import study.object.ch14.time.DateTimeInterval;

import java.util.Arrays;
import java.util.List;

// 단위 시간당 요금 정보
public class FixedFeeCondition implements FeeCondition {

    @Override
    public List<DateTimeInterval> findTimeInterval(Call call) {
        return Arrays.asList(call.getInterval());
    }
}
