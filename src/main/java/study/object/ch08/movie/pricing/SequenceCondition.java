package study.object.ch08.movie.pricing;

import study.object.ch08.movie.DiscountCondition;
import study.object.ch08.movie.Screening;

/**
 * 의존성 전이(p286)
 */
public class SequenceCondition implements DiscountCondition {
    private int sequence; // 상영 순번

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return this.sequence == screening.getSequence();
    }
}
