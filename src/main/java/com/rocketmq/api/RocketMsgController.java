package com.rocketmq.api;

import com.rocketmq.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @program: spring-boot-rocketmq
 * @description:
 * @author: Micky
 * @create: 2019-11-22 16:21
 **/
@Path("/rocketmq")
@Component
public class RocketMsgController {
    @Autowired
    private Consumer consumer;

    @Path("/consumeTopic")
    @GET
    @Consumes({ MediaType.TEXT_PLAIN })
    @Produces({ MediaType.APPLICATION_JSON })
    public Object getConsumeContent(@QueryParam("topic") String topic) throws InterruptedException {
        List<String> list = consumer.consumeTopic(topic);
        int num = 5;
        while (num>0){
            if (list.size()>0){
                return list;
            }else {
                Thread.sleep(5000);
            }
            num--;
        }
        return list;
    }
}
