package study.object.ch01.step02;

// 관람객 - 소지품을 보관하기 위해 가방을 소지할 수 있다
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket) {
       return bag.hold(ticket);
    }
}
