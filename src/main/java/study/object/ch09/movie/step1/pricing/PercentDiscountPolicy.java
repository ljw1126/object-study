package study.object.ch09.movie.step1.pricing;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step1.DiscountCondition;
import study.object.ch09.movie.step1.DiscountPolicy;
import study.object.ch09.movie.step1.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) { // 영화비 * 할인율 = 할인 금액
        return screening.getMovieFee().times(percent);
    }
}
