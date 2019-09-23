package com.nicebody.config;

import com.nicebody.AlipayProperties;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName PropertiesListener
 * @Author Hassan
 * %@Date 2019/9/23 16:25
 */

@Component
public class PropertiesListener  implements ApplicationListener<ApplicationStartedEvent> {
    /**
     * 配置文件监听器，用来加载自定义配置文件
     * @author Louis
     * @date Dec 12, 2018
     */
    @Override
     public void onApplicationEvent(ApplicationStartedEvent event) {
            AlipayProperties.loadProperties();
        }

}
