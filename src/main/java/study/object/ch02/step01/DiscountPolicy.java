package study.object.ch02.step01;

import study.object.ch02.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    protected DiscountPolicy(DiscountCondition... conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : this.conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Screening screening);
}
