package study.object.ch04.movie.step02;

public class Customer {
    private final String name;
    private final String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
