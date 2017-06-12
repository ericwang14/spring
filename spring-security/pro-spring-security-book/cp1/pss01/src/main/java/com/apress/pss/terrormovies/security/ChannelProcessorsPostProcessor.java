package com.apress.pss.terrormovies.security;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.channel.AbstractRetryEntryPoint;
import org.springframework.security.web.access.channel.ChannelEntryPoint;
import org.springframework.security.web.access.channel.InsecureChannelProcessor;
import org.springframework.security.web.access.channel.SecureChannelProcessor;
import org.springframework.stereotype.Component;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
@Component
public class ChannelProcessorsPostProcessor implements BeanPostProcessor {

    @Autowired
    private RedirectStrategy customRedirectStrategy;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ChannelEntryPoint entryPoint = null;

        if (bean instanceof SecureChannelProcessor) {
            entryPoint = ((SecureChannelProcessor) bean).getEntryPoint();
        } else if (bean instanceof InsecureChannelProcessor) {
            entryPoint = ((InsecureChannelProcessor) bean).getEntryPoint();
        }

        if (entryPoint != null && AbstractRetryEntryPoint.class.isAssignableFrom(entryPoint.getClass())) {
            ((AbstractRetryEntryPoint) entryPoint).setRedirectStrategy(customRedirectStrategy);
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
