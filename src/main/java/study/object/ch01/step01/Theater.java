package study.object.ch01.step01;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    /**
     * 문제
     * - 관람객과 판매원이 소극장에 의해 통제는 받는 수동적인 존재
     * - 변경에 취약한 구조
     * - 의존성 강하다, 결합도(coupling)가 높다
     * - 소극장이 관람객과 판매원의 세부 내용까지 알고 있어야 한다
     */
    public void enter(Audience audience ) {
        if(audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
