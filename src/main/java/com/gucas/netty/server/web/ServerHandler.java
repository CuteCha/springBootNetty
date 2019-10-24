package com.gucas.netty.server.web;

import com.gucas.common.disruptor.MessageProducer;
import com.gucas.common.disruptor.RingBufferWorkerPoolFactory;
import com.gucas.common.entity.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by cxq on 2019-10-22 10:06
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        processor1(ctx, msg);
        processor2(ctx, msg);

    }

    private void processor1(ChannelHandlerContext ctx, Object msg) {
        TranslatorData request = (TranslatorData) msg;
        System.err.println("Sever端: id= " + request.getId()
                + ", name= " + request.getName()
                + ", message= " + request.getMessage());
        //数据库持久化操作 IO读写 ---> 交给一个线程池 去异步的调用执行
        TranslatorData response = new TranslatorData();
        response.setId("resp: " + request.getId());
        response.setName("resp: " + request.getName());
        response.setMessage("resp: " + request.getMessage());
        //写出response响应信息:
        ctx.writeAndFlush(response);
    }

    private void processor2(ChannelHandlerContext ctx, Object msg) {
        TranslatorData request = (TranslatorData) msg;
        String producerId = "code:sessionId:0001";
        MessageProducer messageProducer = RingBufferWorkerPoolFactory.getInstance().getMessageProducer(producerId);
        messageProducer.onData(request, ctx);
    }
}
