package com.gucas.netty.client;

import com.gucas.netty.client.web.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by cxq on 2019-10-22 10:08
 */

@SpringBootApplication
public class NettyClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyClientApplication.class, args);

        //建立连接 并发送消息
        new NettyClient().sendData();
    }

}
