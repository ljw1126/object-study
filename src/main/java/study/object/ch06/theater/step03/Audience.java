package study.object.ch06.theater.step03;

public class Audience {
    private Bag bag;

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
