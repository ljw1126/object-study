package study.object.ch05.movie.step05;

import study.object.ch05.money.Money;

/**
 * p199 몬스터 메소드를 분리해본다
 */
public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions()
                .stream().anyMatch(condition -> condition.isDiscountable(screening));
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                    .minus(calculateDiscountedFee(screening.getMovie()))
                    .times(audienceCount);
        }

        return screening.getMovie().getFee().times(audienceCount);
    }

    private Money calculateDiscountedFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountFee(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountFee(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountFee(movie);
        }

        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountFee(Movie movie) {
        return Money.ZERO;
    }
}
