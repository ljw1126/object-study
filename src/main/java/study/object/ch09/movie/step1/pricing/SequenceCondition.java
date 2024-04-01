package study.object.ch09.movie.step1.pricing;

import study.object.ch09.movie.step1.DiscountCondition;
import study.object.ch09.movie.step1.Screening;

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
