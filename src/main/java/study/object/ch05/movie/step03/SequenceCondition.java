package study.object.ch05.movie.step03;

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
