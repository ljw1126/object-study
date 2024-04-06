package study.object.ch14.time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DateTimeIntervalTest {

    private LocalDateTime from;
    private LocalDateTime to;

    @BeforeEach
    void setUp() {
        from = LocalDateTime.of(2024, 1, 1, 10, 0, 0);
        to = LocalDateTime.of(2024, 1, 3, 15, 0, 0);
    }

    @Test
    void duration() {
        DateTimeInterval dateTimeInterval = DateTimeInterval.of(from, to);
        Duration duration = dateTimeInterval.duration();

        // 14시간 + 24시간 + 15시간 = 53시간
        assertThat(duration).isEqualTo(Duration.ofHours(53));
    }

    @DisplayName("1/1 10시 ~ 24시, 1/2일 0시 ~ 24시, 1/3일 0시 ~ 15시 정보를 반환한다")
    @Test
    void splitByDay() {
        DateTimeInterval dateTimeInterval = DateTimeInterval.of(from, to);
        List<DateTimeInterval> result = dateTimeInterval.splitByDay();

        assertThat(result)
                .hasSize(3)
                .containsExactly(
                        DateTimeInterval.toMidnight(from),
                        DateTimeInterval.during(from.toLocalDate().plusDays(1)),
                        DateTimeInterval.fromMidnight(to)
                );
    }

    @DisplayName("1/1일 10시 ~ 24시 통화할 경우 splitByDay()는 하루가 주어진다")
    @Test
    void zero_day() {
        DateTimeInterval dateTimeInterval = DateTimeInterval.toMidnight(from); // from ~ 24시
        List<DateTimeInterval> result = dateTimeInterval.splitByDay();

        assertThat(result).hasSize(1);
    }
}
