package study.object.ch06.theater.step03;

/**
 * 디미터 원칙에 따라 리팩토링
 * ~p227
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
