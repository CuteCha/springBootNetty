package com.gucas.netty.client;

import com.gucas.common.disruptor.MessageConsumer;
import com.gucas.common.disruptor.RingBufferWorkerPoolFactory;
import com.gucas.netty.client.util.MessageConsumerImpl4Client;
import com.gucas.netty.client.web.NettyClient;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by cxq on 2019-10-22 10:08
 */

@SpringBootApplication
public class NettyClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyClientApplication.class, args);

//        jobs1();
        jobs2();
    }

    public static void jobs1() {
        //建立连接 并发送消息
        new NettyClient().sendData();
    }

    public static void jobs2() {
        MessageConsumer[] conusmers = new MessageConsumer[4];
        for (int i = 0; i < conusmers.length; i++) {
            MessageConsumer messageConsumer = new MessageConsumerImpl4Client("code:clientId:" + i);
            conusmers[i] = messageConsumer;
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI,
                1024 * 1024,
                //new YieldingWaitStrategy(),
                new BlockingWaitStrategy(),
                conusmers);

        //建立连接 并发送消息
        new NettyClient().sendData();
    }
}
