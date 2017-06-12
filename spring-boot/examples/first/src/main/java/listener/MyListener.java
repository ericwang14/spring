package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by wanggang on 9/15/16.
 */
public class MyListener implements ApplicationListener {

    private final static Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.debug("My Listener triggered, source: {}", applicationEvent.getSource());
    }
}
