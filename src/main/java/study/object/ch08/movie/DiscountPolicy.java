package study.object.ch08.movie;

import study.object.ch08.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> discountConditions = new ArrayList<>();

    // 생성자에서 주입하는 방식
    public DiscountPolicy(DiscountCondition... discountConditions) {
        this.discountConditions.addAll(Arrays.asList(discountConditions));
    }

    public Money isDiscountable(Screening screening) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.isSatisfiedBy(screening)) {
                return calculateDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    // setter 통해 대체할 수 있도록 지원하는 방식
    public void switchConditions(List<DiscountCondition> conditions) {
        this.discountConditions = conditions;
    }

    protected abstract Money calculateDiscountAmount(Screening screening);
}
