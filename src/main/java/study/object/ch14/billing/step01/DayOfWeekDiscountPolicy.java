package study.object.ch14.billing.step01;

import study.object.ch14.money.Money;
import study.object.ch14.time.DateTimeInterval;

import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {
    private List<DayOfWeekDiscountRule> rules = new ArrayList<>(); // 요일별 요금 정책

    public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
        this.rules = rules;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;

        for (DateTimeInterval interval : call.splitByDay()) {
            for (DayOfWeekDiscountRule rule : rules) {
                result.plus(rule.calculate(interval));
            }
        }

        return result;
    }
}
