package com.gucas.netty.server;

import com.gucas.netty.server.web.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by cxq on 2019-10-22 09:59
 */

@SpringBootApplication
public class NettyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class, args);

        new NettyServer();
    }
}
