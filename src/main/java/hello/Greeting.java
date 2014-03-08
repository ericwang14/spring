package hello;

/**
 * Created with IntelliJ IDEA.
 * User: wanggang
 * Date: 3/4/14
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Greeting {
    private final long id;
    private final String name;

    public Greeting(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
