package study.object.ch06.event.step01;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek()
                || !from.toLocalTime().equals(schedule.getFrom())
                || !duration.equals(schedule.getDuration())) {
            reschedule(schedule); // command와 query가 공존하고 있어 버그 유발
            return false;
        }

        return true;
    }

    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return (long) schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
