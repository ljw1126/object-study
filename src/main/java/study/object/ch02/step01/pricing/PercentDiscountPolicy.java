package study.object.ch02.step01.pricing;

import study.object.ch02.money.Money;
import study.object.ch02.step01.DiscountCondition;
import study.object.ch02.step01.DiscountPolicy;
import study.object.ch02.step01.Screening;

// 퍼센트 할인
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
