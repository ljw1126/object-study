package study.object.ch08.movie.pricing;

import study.object.ch08.money.Money;
import study.object.ch08.movie.DiscountPolicy;
import study.object.ch08.movie.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 중복 할인
 */
public class OverlappedDiscountPolicy extends DiscountPolicy {
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
        this.discountPolicies.addAll(Arrays.asList(discountPolicies));
    }

    @Override
    protected Money calculateDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            result = result.plus(discountPolicy.isDiscountable(screening));
        }
        return result;
    }
}
