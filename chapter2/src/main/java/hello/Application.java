package hello;

import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: wanggang
 * Date: 3/6/14
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Application {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        Page page = template.getForObject("http://graph.facebook.com/gopivotal", Page.class);
        System.out.println("Name:    " + page.getName());
        System.out.println("About:   " + page.getAbout());
        System.out.println("Phone:   " + page.getPhone());
        System.out.println("Website: " + page.getWebsite());
    }
}
