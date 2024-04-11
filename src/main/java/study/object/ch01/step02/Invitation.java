package study.object.ch01.step02;

import java.time.LocalDateTime;

// 초대장
public class Invitation {
    private final LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public LocalDateTime getWhen() {
        return when;
    }

}
