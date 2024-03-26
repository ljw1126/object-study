package study.object.ch06.event.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Command-Query 예제 p232
 * - 객체의 상태를 변경하는 명령(Commnad)은 반환값을 가질 수 없다
 * - 객체의 정보를 반환하는 쿼리(Query)는 상태를 변경할 수 없다
 * <p>
 * assert 사용시 VM Optionam에 -ea 또는 -enableassertions 추가해야 동작함
 */
public class EventApplication {
    public static void main(String[] args) {
        // 2019년 5월 8일 수요일 10시 30분 ~ 11시까지 열리는 회의 표현
        Event meeting = new Event("회의",
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30)
        );

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

        assert meeting.isSatisfied(schedule) == true;
        assert meeting2.isSatisfied(schedule) == false; // 명령과 쿼리를 동시에 수행(문제), 부수 효과로 인해 실행 결과를 예측하기 어려워짐, 곧 버그 양산 가능
        assert meeting2.isSatisfied(schedule) == true;
    }
}
