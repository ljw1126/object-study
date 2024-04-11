package study.object.ch06.theater.step03;

import java.time.LocalDateTime;

public class Invitation {
    private final LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public LocalDateTime getWhen() {
        return when;
    }

}
