package study.object.ch14.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DateTimeInterval {
    private LocalDateTime from; // 시작 시간
    private LocalDateTime to; // 종료 시간

    public static DateTimeInterval of(LocalDateTime from, LocalDateTime to) {
        return new DateTimeInterval(from, to);
    }

    // 현재 ~ 당일 23시까지
    public static DateTimeInterval toMidnight(LocalDateTime from) {
        return new DateTimeInterval(from, LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59, 999_999_999)));
    }

    // 자정 (0시) ~ 현재 to 까지
    public static DateTimeInterval fromMidnight(LocalDateTime to) {
        return new DateTimeInterval(LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)), to); // (날짜, 시간)
    }

    // 당일 0시 0분 ~ 당일 23시 59분 59초
    public static DateTimeInterval during(LocalDate date) {
        return new DateTimeInterval(
                LocalDateTime.of(date, LocalTime.of(0, 0)),
                LocalDateTime.of(date, LocalTime.of(23, 59, 59, 999_999_999))
        );
    }

    public DateTimeInterval(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    // 총 통화 시간
    public Duration duration() {
        return Duration.between(from, to);
    }

    public List<DateTimeInterval> splitByDay() {
        if (days() > 0) {
            return split(days());
        }

        return Arrays.asList(this);
    }

    // from ~ to까지의 일 수
    private long days() {
        return Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay()).toDays();
    }

    private List<DateTimeInterval> split(long days) {
        List<DateTimeInterval> result = new ArrayList<>();
        addFirstDay(result);
        addMiddleDays(result, days);
        addLastDay(result);
        return result;
    }

    private void addFirstDay(List<DateTimeInterval> result) {
        result.add(DateTimeInterval.toMidnight(from)); // 당일 from ~  밤 23시 59분까지
    }

    private void addMiddleDays(List<DateTimeInterval> result, long days) { // days가 2일 이상인 경우
        for (int loop = 1; loop < days; loop++) {
            result.add(DateTimeInterval.during(from.toLocalDate().plusDays(loop)));
        }
    }

    private void addLastDay(List<DateTimeInterval> result) {
        result.add(DateTimeInterval.fromMidnight(to)); // 밤(0시0분) ~ 당일 to 까지
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DateTimeInterval that = (DateTimeInterval) other;
        return Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "DateTimeInterval{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
