package study.object.ch02.step01.pricing;

import study.object.ch02.money.Money;
import study.object.ch02.step01.DiscountPolicy;
import study.object.ch02.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
