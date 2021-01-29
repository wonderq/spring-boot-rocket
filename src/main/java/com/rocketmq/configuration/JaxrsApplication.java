package com.rocketmq.configuration;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @program: spring-boot-rocketmq
 * @description:
 * @author: Micky
 * @create: 2019-11-22 19:22
 **/

@Component
@ApplicationPath("/")
public class JaxrsApplication extends Application {
}
