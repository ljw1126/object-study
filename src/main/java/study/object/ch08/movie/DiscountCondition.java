package study.object.ch08.movie;

// 할인 조건 : 순번/기간 조건
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
