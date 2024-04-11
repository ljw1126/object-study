package study.object.ch06.event.step02;

import study.object.ch06.event.step01.Event;
import study.object.ch06.event.step01.RecurringSchedule;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Event 클래스에서 Command-Query 분리하여 부수효과(버그) 방지
 * - 실행시 VM Option에 -ea 추가 필요
 */
public class EventApplication {
    public static void main(String[] args) {
        // 2019년 5월 8일 수요일 10시 30분 ~ 11시까지 열리는 회의 표현
        Event meeting = new Event("회의",
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30)
        );

        System.out.println(meeting);

        // 매주 수요일 10시 30분 ~ 30분 동안 열리는 회의
        RecurringSchedule schedule = new RecurringSchedule(
                "회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30)
        );

        // 5월 10일은 금요일
        Event meeting2 = new Event("회의",
                LocalDateTime.of(2019, 5, 10, 10, 30),
                Duration.ofMinutes(30)
        );

        if (!meeting2.isSatisfied(schedule)) {
            meeting2.reschedule(schedule);
        }

        assert meeting2.isSatisfied(schedule);
    }
}
