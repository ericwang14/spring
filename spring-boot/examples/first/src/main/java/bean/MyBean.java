package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by wanggang on 9/15/16.
 */
@Component
class MyBean implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(MyBean.class);

    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean isDebug = args.containsOption("debug");

        logger.debug("application running in {} mode", isDebug ? "normal" : "debug");
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.debug("{}", (Object[])strings);
    }

}
