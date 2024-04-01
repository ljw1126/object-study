package study.object.ch09.movie.step3.pricing;

import study.object.ch09.movie.step3.DiscountCondition;
import study.object.ch09.movie.step3.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
