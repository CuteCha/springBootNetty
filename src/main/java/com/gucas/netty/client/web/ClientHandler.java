package com.gucas.netty.client.web;

import com.gucas.common.disruptor.MessageProducer;
import com.gucas.common.disruptor.RingBufferWorkerPoolFactory;
import com.gucas.common.entity.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by cxq on 2019-10-22 10:11
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        processor1(ctx, msg);
        processor2(ctx, msg);

    }

    private void processor1(ChannelHandlerContext ctx, Object msg) {
        try {
            TranslatorData response = (TranslatorData) msg;
            System.err.println("Client端: id= " + response.getId()
                    + ", name= " + response.getName()
                    + ", message= " + response.getMessage());
        } finally {
            //一定要注意 用完了缓存 要进行释放
            ReferenceCountUtil.release(msg);
        }
    }

    private void processor2(ChannelHandlerContext ctx, Object msg) {
        TranslatorData response = (TranslatorData) msg;
        String producerId = "code:sessionId:002";
        MessageProducer messageProducer = RingBufferWorkerPoolFactory.getInstance().getMessageProducer(producerId);
        messageProducer.onData(response, ctx);
    }
}
