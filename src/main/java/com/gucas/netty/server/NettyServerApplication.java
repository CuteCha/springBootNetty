package com.gucas.netty.server;

import com.gucas.common.disruptor.MessageConsumer;
import com.gucas.common.disruptor.RingBufferWorkerPoolFactory;
import com.gucas.netty.server.util.MessageConsumerImpl4Server;
import com.gucas.netty.server.web.NettyServer;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by cxq on 2019-10-22 09:59
 */

@SpringBootApplication
public class NettyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class, args);
//        jobs1();
        jobs2();
    }

    private static void jobs1() {
        new NettyServer();
    }

    private static void jobs2() {
        MessageConsumer[] consumers = new MessageConsumer[4];
        for (int i = 0; i < consumers.length; i++) {
            MessageConsumer messageConsumer = new MessageConsumerImpl4Server("code:serverId:" + i);
            consumers[i] = messageConsumer;
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI,
                1024 * 1024,
                //new YieldingWaitStrategy(),
                new BlockingWaitStrategy(),
                consumers);

        new NettyServer();

    }
}
