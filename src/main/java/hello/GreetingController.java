package hello;

import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: wanggang
 * Date: 3/4/14
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
//    public @ResponseBody Greeting greeting(
//            @RequestParam(value="name", required=false, defaultValue="world") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}
