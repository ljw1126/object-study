package study.object.ch01.step01;

// 판매원
public class TicketSeller {
    private TicketOffice ticketOffice; // 매표소를 알고 있다

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
