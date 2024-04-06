package study.object.ch14.time;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * step14 TimeOfDayDiscountPolicy 시간대별 요금제
 */
public class LocalTimeTest {
    private final Logger LOGGER = LoggerFactory.getLogger(LocalTimeTest.class);

    /**
     * 시간대별 정책이 아래와 같고
     * 00시 ~ 19시까지 10초당 18원
     * 19시 ~ 24시까지 10초당 15원
     * <p>
     * from : 00시, to : 19시, duration : 10초당, money : 18원
     * from : 19시, to : 24시, duration : 10초당, money : 15원
     *
     * <p>
     * 통화를 1월1일 10시 ~ 1월 3일 15시까지 했을때
     * - splitByDay()는 1/1 10시 ~ 24시, 1/2일 0시 ~ 24시, 1/3일 0시 ~ 15시 정보 반환한다
     * <p>
     * 1월 1일에 10시 ~ 23:59:59에 대한 요금을 구할 경우
     * 첫번째
     * - 10시 ~ 19시 통화시간이 구해짐
     * - Duration.between(10시, 19시) = 21시간
     */
    @Test
    void from() {
        LocalDateTime from = LocalDateTime.of(2024, 1, 1, 10, 0, 0);

        LocalTime localTime = from.toLocalTime();
        LOGGER.info("toLocalTime : {}", localTime); // 10 : 00

        LocalTime other = LocalTime.of(0, 0); // 0 시 0분

        assertThat(localTime.isBefore(other)).isFalse(); // 10시는 0시 이전이 아니다
    }

    @Test
    void to() {
        LocalDateTime to = LocalDateTime.of(2024, 1, 1, 23, 59, 59);
        LocalTime localTime = to.toLocalTime();
        LOGGER.info("toLocalTime : {}", localTime); // 23:59:59

        LocalTime other = LocalTime.of(19, 0);

        assertThat(localTime.isAfter(other)).isTrue(); // 23:59:59는 19시 이후이다
    }

    /**
     * 1월 1일에 10시 ~ 23:59:59에 대한 요금을 구할 경우
     * 두번째
     * - 19시 ~ 23:59:59시 통화시간이 구해짐
     * - Duration.between(10시, 19시) = 21시간
     */
    @Test
    void from2() {
        LocalDateTime from = LocalDateTime.of(2024, 1, 1, 10, 0, 0);

        LocalTime localTime = from.toLocalTime();
        LOGGER.info("toLocalTime : {}", localTime); // 10 : 00

        LocalTime other = LocalTime.of(19, 0); // 19 시 0분 (기준)

        assertThat(localTime.isBefore(other)).isTrue(); // 10시는 19시 이전이다
    }

    @Test
    void to2() {
        LocalDateTime to = LocalDateTime.of(2024, 1, 1, 23, 59, 59);
        LocalTime localTime = to.toLocalTime();
        LOGGER.info("toLocalTime : {}", localTime); // 23:59:59

        LocalTime other = LocalTime.of(23, 59, 59); // 0시 (기준)

        assertThat(localTime.isAfter(other)).isFalse(); //
    }

}
