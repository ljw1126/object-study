package study.object.ch05.movie.step05;

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
