package hello;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: wanggang
 * Date: 3/6/14
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
@EnableScheduling
public class ScheduleTask {

    @Scheduled(cron="0 */1 * * * *")
    public void runner() {
        System.out.println(Calendar.getInstance().getTime());
    }
}
