package study.object.ch09.movie.step2.client;

import study.object.ch09.money.Money;
import study.object.ch09.movie.step2.Movie;

public class Client {

    private final Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatarMovie = factory.createAvatarMovie();
        return avatarMovie.getFee();
    }
}
