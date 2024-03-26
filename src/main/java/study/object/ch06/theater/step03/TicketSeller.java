package study.object.ch06.theater.step03;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    public void sellTo(Audience audience) {
        long fee = audience.buy(ticketOffice.getTicket());
        ticketOffice.plusAmount(fee);
    }
}
